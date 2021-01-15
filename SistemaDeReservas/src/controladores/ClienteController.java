package controladores;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import  models.Cliente;
import models.iCliente;

public class ClienteController implements iClienteController{

    // #########
    // # CRUDS #
    // #########
 
    @Override
	public int add (iCliente oCliente) {
	int iRes = 0;

	if (oCliente.validaCliente()) {
	   

		// 2) Anado la Cliente
		String sql = "INSERT INTO Cliente VALUES (";
	    sql += "\""+oCliente.getDNI()+"\",";
	    sql += "\""+oCliente.getNombre()+"\",";
	    sql += "\""+oCliente.getApellidos()+"\",";
	    sql += "\""+oCliente.getEmail()+"\",";
	    sql += "\""+oCliente.getTelefono()+"\",";    
	    sql += ")";
	    iRes = ConexionDB.executeUpdate(sql);
	    }
	return iRes;
    }
	
    
    @Override
	public int update (iCliente oCliente) {
	int iRes = 0;
	if (oCliente.validaCliente()) {

	    String sql = "UPDATE Cliente ";
	    sql += "SET Nombre = \"" + oCliente.getNombre() + "\", ";
	    sql += "Apellidos = \"" + oCliente.getApellidos() + "\", ";
	    sql += "Telefono = \"" + oCliente.getTelefono() + "\", ";
	    sql += "Nombre = \"" + oCliente.getEmail() + "\" ";
	    sql += "WHERE DNI=" + oCliente.getDNI();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }
  
    @Override
	public int remove (iCliente oCliente) {
	int iRes = 0;
	if (oCliente.validaCliente()) {
	    String sql = "DELETE FROM Cliente WHERE DNI LIKE \"" + oCliente.getDNI();
	    iRes = ConexionDB.executeUpdate(sql);
	}
	return iRes;
    }

    // ##########
    // # QUERYS #
    // ##########
 
    @Override
	public int existeCliente (iCliente oCliente) {
	int iRes = 0;
	if (oCliente.validaCliente()) {
	    String sql = "SELECT COUNT(*) FROM Cliente WHERE DNI=\"" + oCliente.getDNI();;
	    iRes = ConexionDB.executeCount(sql);
	}
	return iRes;
    }
    @Override
	public List<Cliente>  searchAddressesPorDNI (iCliente oCliente) {
		
    	List<Cliente> lCliente = new ArrayList<Cliente>();	
    	String sql = "SELECT * FROM Cliente WHERE DNI=" + oCliente.getDNI();
    	Statement stm = null;
    	
    	try {
    	    stm = ConexionDB.getConnection().createStatement();
    	    ResultSet rs = stm.executeQuery(sql);
    	    while (rs.next()) {
    		String DNI = rs.getString(1);
    		String Nombre = rs.getString(2);
    		String Apellidos = rs.getString(3);
    		int Telefono = rs.getInt(4);
    		String email = rs.getString(5);		
    		lCliente.add(new Cliente(DNI, Nombre, Apellidos, Telefono, email));
    	    }
    	    stm.close();
    	} catch (SQLException e) {
    		lCliente = null;
    	}	
    	return lCliente;	
        }
}