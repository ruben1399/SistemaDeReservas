package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Tarifa;
import models.iTarifa;

public class TarifaController implements iTarifaController {

    // #########
    // # CRUDS #
    // #########
 
    @Override
	public int add (iTarifa oTarifa) {
	int iRes = 0;

	if (oTarifa.validaTarifa()) {
	   

		// 2) Anado la Tarifa
		String sql = "INSERT INTO Tarifa VALUES (";
	    sql += "\""+oTarifa.getId_Tarifa()+"\",";
	    sql += "\""+oTarifa.getPrecio()+"\",";
	    sql += ")";
	    iRes = ConexionDB.executeUpdate(sql);
	    }
	return iRes;
    }
	
    
    @Override
	public int update (iTarifa oTarifa) {
	int iRes = 0;
	if (oTarifa.validaTarifa()) {

	    String sql = "UPDATE Tarifa ";
	    sql += "SET Precio = \"" + oTarifa.getPrecio() + "\" ";
	    sql += "WHERE Id_Tarifa=" + oTarifa.getId_Tarifa();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }
  
    @Override
	public int remove (iTarifa oTarifa) {
	int iRes = 0;
	if (oTarifa.validaTarifa()) {
	    String sql = "DELETE FROM Tarifa WHERE Id_Tarifa LIKE \"" + oTarifa.getId_Tarifa();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }

    // ##########
    // # QUERYS #
    // ##########
 
    @Override
	public int existeTarifa (iTarifa oTarifa) {
	int iRes = 0;
	if (oTarifa.validaTarifa()) {
	    String sql = "SELECT COUNT(*) FROM Tarifa WHERE Id_Tarifa=\"" + oTarifa.getId_Tarifa();
	    iRes = ConexionDB.executeCount(sql);
	}
	return iRes;
    }
    @Override
	public List<Tarifa>  searchPorId_Tarifa (iTarifa oTarifa) {
		
    	List<Tarifa> lTarifa = new ArrayList<Tarifa>();	
    	String sql = "SELECT * FROM Tarifa WHERE Id_Tarifa=" + oTarifa.getId_Tarifa();
    	Statement stm = null;
    	
    	try {
    	    stm = ConexionDB.getConnection().createStatement();
    	    ResultSet rs = stm.executeQuery(sql);
    	    while (rs.next()) {
    		int Id_Tarifa = rs.getInt(1);
    		int Precio = rs.getInt(2);	
    		lTarifa.add(new Tarifa(Id_Tarifa, Precio));
    	    }
    	    stm.close();
    	} catch (SQLException e) {
    		lTarifa = null;
    	}	
    	return lTarifa;	
        }
}