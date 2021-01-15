package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Horario;
import models.iHorario;

public class HorarioController implements iHorarioController {

    // #########
    // # CRUDS #
    // #########
 
    @Override
	public int add (iHorario oHorario) {
	int iRes = 0;

	if (oHorario.validaHorario()) {
	   

		// 2) Anado la Horario
		String sql = "INSERT INTO Horario VALUES (";
	    sql += "\""+oHorario.getId_Horario()+"\",";
	    sql += "\""+oHorario.getHora()+"\",";
	    sql += ")";
	    iRes = ConexionDB.executeUpdate(sql);
	    }
	return iRes;
    }
	
    
    @Override
	public int update (iHorario oHorario) {
	int iRes = 0;
	if (oHorario.validaHorario()) {

	    String sql = "UPDATE Horario ";
	    sql += "SET Precio = \"" + oHorario.getHora() + "\" ";
	    sql += "WHERE Id_Horario=" + oHorario.getId_Horario();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }
  
    @Override
	public int remove (iHorario oHorario) {
	int iRes = 0;
	if (oHorario.validaHorario()) {
	    String sql = "DELETE FROM Horario WHERE Id_Horario LIKE \"" + oHorario.getId_Horario();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }

    // ##########
    // # QUERYS #
    // ##########
 
    @Override
	public int existeHorario (iHorario oHorario) {
	int iRes = 0;
	if (oHorario.validaHorario()) {
	    String sql = "SELECT COUNT(*) FROM Horario WHERE Id_Horario=\"" + oHorario.getId_Horario();
	    iRes = ConexionDB.executeCount(sql);
	}
	return iRes;
    }
    @Override
	public List<Horario>  searchPorId_Horario (iHorario oHorario) {
		
    	List<Horario> lHorario = new ArrayList<Horario>();	
    	String sql = "SELECT * FROM Horario WHERE Id_Horario=" + oHorario.getId_Horario();
    	Statement stm = null;
    	
    	try {
    	    stm = ConexionDB.getConnection().createStatement();
    	    ResultSet rs = stm.executeQuery(sql);
    	    while (rs.next()) {
    		int Id_Horario = rs.getInt(1);
    		String Hora = rs.getString(2);	
    		lHorario.add(new Horario(Id_Horario, Hora));
    	    }
    	    stm.close();
    	} catch (SQLException e) {
    		lHorario = null;
    	}	
    	return lHorario;	
        }
}