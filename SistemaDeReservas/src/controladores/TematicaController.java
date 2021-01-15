package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Tematica;
import models.iTematica;

public class TematicaController implements iTematicaController {

    // #########
    // # CRUDS #
    // #########
 
    @Override
	public int add (iTematica oTematica) {
	int iRes = 0;

	if (oTematica.validaTematica()) {
	   

		// 2) Anado la Tematica
		String sql = "INSERT INTO Tematica VALUES (";
	    sql += "\""+oTematica.getId_Temat()+"\",";
	    sql += "\""+oTematica.getNombre()+"\",";
	    sql += "\""+oTematica.getDescripcion()+"\",";
	    sql += ")";
	    iRes = ConexionDB.executeUpdate(sql);
	    }
	return iRes;
    }
	
    
    @Override
	public int update (iTematica oTematica) {
	int iRes = 0;
	if (oTematica.validaTematica()) {

	    String sql = "UPDATE Tematica ";
	    sql += "SET Precio = \"" + oTematica.getNombre() + "\" ";
	    sql += "WHERE Id_Temat=" + oTematica.getDescripcion();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }
  
    @Override
	public int remove (iTematica oTematica) {
	int iRes = 0;
	if (oTematica.validaTematica()) {
	    String sql = "DELETE FROM Tematica WHERE Id_Temat LIKE \"" + oTematica.getId_Temat();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }

    // ##########
    // # QUERYS #
    // ##########
 
    @Override
	public int existeTematica (iTematica oTematica) {
	int iRes = 0;
	if (oTematica.validaTematica()) {
	    String sql = "SELECT COUNT(*) FROM Tematica WHERE Id_Temat=\"" + oTematica.getId_Temat();
	    iRes = ConexionDB.executeCount(sql);
	}
	return iRes;
    }
    @Override
	public List<Tematica>  searchPorId_Temat (iTematica oTematica) {
		
    	List<Tematica> lTematica = new ArrayList<Tematica>();	
    	String sql = "SELECT * FROM Tematica WHERE Id_Temat=" + oTematica.getId_Temat();
    	Statement stm = null;
    	
    	try {
    	    stm = ConexionDB.getConnection().createStatement();
    	    ResultSet rs = stm.executeQuery(sql);
    	    while (rs.next()) {
    		int Id_Temat = rs.getInt(1);
    		String Hora = rs.getString(2);	
    		lTematica.add(new Tematica(Id_Temat, Hora));
    	    }
    	    stm.close();
    	} catch (SQLException e) {
    		lTematica = null;
    	}	
    	return lTematica;	
        }
}