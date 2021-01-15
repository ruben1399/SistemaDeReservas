package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private String host = "localhost";
	private String port = "3306";
	private String user = "root";
	private String password = "12345678910";
	private String pattern = "jdbc:mysql://" + host + ":" + port + "/";
	private static Connection connectionDb = null;

	public ConexionDB(String database) {
		String url = pattern + database;

		// Registramos el Driver
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MariaDB: " + ex);
		}

		// Establecemos la conexion
		try {
			connectionDb = DriverManager.getConnection(url, user, password);
		} catch (Exception sqle) {
			connectionDb = null;
		}
	}

	public static boolean checkConnectionDatabase() {
		boolean bConnected;
		try {
			connectionDb.isValid(5000);
			bConnected = true;
		} catch (Exception e) {
			bConnected = false;
		}
		return bConnected;
	}

	public static void disconnectDatabase() {
		try {
			connectionDb.close();
		} catch (Exception e) {
			connectionDb = null;
		}
	}

	public static Connection getConnection() {
		return connectionDb;
	}

	public static int executeCount(String sql) {
		Statement stm = null;
		ResultSet rs = null;
		int iCount = 0;

		try {
			stm = ConexionDB.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				iCount = rs.getInt(1);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			iCount = 0;
		}

		return iCount;
	}

	public static int executeUpdate(String sql) {
		Statement stm = null;
		int iCount = 0;

		try {
			stm = ConexionDB.getConnection().createStatement();
			iCount = stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			iCount = 0;
		}
		return iCount;
	}

}
