package edu.example.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Obtener una conexion para acceder a la base de datos de Derby
 * @author ChoySs
 *
 */
public class ConnectionDB {

	String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	String uri = "jdbc:derby:MyDerbyDb;create=true";
	
	private static ConnectionDB connectionDB = null;
	
	private ConnectionDB() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(uri);
		return conn;
	}
	
	public static ConnectionDB getInstance() {
		if(connectionDB == null) {
			connectionDB = new ConnectionDB();
		}
		return connectionDB;
	}
}
