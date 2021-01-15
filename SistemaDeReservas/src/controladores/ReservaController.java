package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Reserva;

public class ReservaController {

	// #########
	// # CRUDS #
	// #########

	public int add(Reserva oReserva) {
		int iRes = 0;

		if (oReserva.validaReserva()) {

			// 2) Anado la Reserva
			String sql = "INSERT INTO Reserva VALUES (";
			sql += "\"" + oReserva.getId_Reserva() + "\",";
			sql += "\"" + oReserva.getHoras() + "\",";
			sql += "\"" + oReserva.getoCliente().getDNI() + "\",";
			sql += "\"" + oReserva.getoJuego().getId_Juego() + "\"";
			sql += ")";
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	public int update(Reserva oReserva) {
		int iRes = 0;
		if (oReserva.validaReserva()) {

			String sql = "UPDATE Reserva ";
			sql += "SET Nombre = \"" + oReserva.getHoras() + "\", ";
			sql += "DNI = \"" + oReserva.getoCliente().getDNI() + "\", ";
			sql += "Juego = \"" + oReserva.getoJuego().getId_Juego() + "\", ";
			sql += "WHERE Id_Reserva=" + oReserva.getId_Reserva();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	public int remove(Reserva oReserva) {
		int iRes = 0;
		if (oReserva.validaReserva()) {
			String sql = "DELETE FROM Reserva WHERE Id_Reserva LIKE \"" + oReserva.getId_Reserva();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return iRes;
	}

	// ##########
	// # QUERYS #
	// ##########

	public int existeReserva(Reserva oReserva) {
		int iRes = 0;
		if (oReserva.validaReserva()) {
			String sql = "SELECT COUNT(*) FROM Reserva WHERE Id_Reserva=\"" + oReserva.getId_Reserva();
			iRes = ConexionDB.executeCount(sql);
		}
		return iRes;
	}

	public List<Reserva> searchPorId_Reserva(Reserva oReserva) {

		List<Reserva> lReserva = new ArrayList<Reserva>();
		String sql = "SELECT * FROM Reserva WHERE Id_Reserva=" + oReserva.getId_Reserva();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int Id_Reserva = rs.getInt(1);
				String Horas = rs.getString(2);
				Object DNI = rs.getObject(3);
				Object Id_Juego = rs.getObject(4);
				lReserva.add(new Reserva(Id_Reserva, Horas, DNI, Id_Juego));
			}
			stm.close();
		} catch (SQLException e) {
			lReserva = null;
		}
		return lReserva;
	}
}