package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Juego;
import models.iHorario;
import models.iJuego;
import models.iTarifa;
import models.iTematica;

public class JuegoController implements iJuegoController {

	// #########
	// # CRUDS #
	// #########

	@Override
	public int add(iJuego oJuego) {
		int iRes = 0;

		if (oJuego.validaJuego()) {

			// 2) Anado la Juego
			String sql = "INSERT INTO Juego VALUES (";
			sql += "\"" + oJuego.getId_Juego() + "\",";
			sql += "\"" + oJuego.getNombre() + "\",";
			sql += "\"" + oJuego.getoHorario() + "\",";
			sql += "\"" + oJuego.getoTarifa() + "\",";
			sql += "\"" + oJuego.getoTematica() + "\"";
			sql += ")";
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	@Override
	public int update(iJuego oJuego) {
		int iRes = 0;
		if (oJuego.validaJuego()) {

			String sql = "UPDATE Juego ";
			sql += "SET Nombre = \"" + oJuego.getNombre() + "\", ";
			sql += "Tarifa = \"" + oJuego.getoTarifa().getId_Tarifa() + "\", ";
			sql += "Horario = \"" + oJuego.getoHorario().getId_Horario() + "\", ";
			sql += "Tematica = \"" + oJuego.getoTematica().getId_Temat() + "\" ";
			sql += "WHERE Id_Juego=" + oJuego.getId_Juego();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	@Override
	public int remove(iJuego oJuego) {
		int iRes = 0;
		if (oJuego.validaJuego()) {
			String sql = "DELETE FROM Juego WHERE Id_Juego LIKE \"" + oJuego.getId_Juego();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	// ##########
	// # QUERYS #
	// ##########

	@Override
	public int existeJuego(iJuego oJuego) {
		int iRes = 0;
		if (oJuego.validaJuego()) {
			String sql = "SELECT COUNT(*) FROM Juego WHERE Id_Juego=\"" + oJuego.getId_Juego();
			iRes = ConexionDB.executeCount(sql);
		}
		return iRes;
	}

	@Override
	public List<Juego> searchPorId_Juego(iJuego oJuego) {

		List<Juego> lJuego = new ArrayList<Juego>();
		String sql = "SELECT * FROM Juego WHERE Id_Juego=" + oJuego.getId_Juego();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int Id_Juego = rs.getInt(1);
				String Nombre = rs.getString(2);
				iTarifa oTarifa = (iTarifa) rs.getObject(3);
				iHorario oHorario = (iHorario) rs.getObject(4);
				iTematica oTematica = (iTematica) rs.getObject(5);
				lJuego.add(new Juego(Id_Juego, Nombre, oHorario, oTematica, oTarifa));
			}
			stm.close();
		} catch (SQLException e) {
			lJuego = null;
		}
		return lJuego;
	}
}