package edu.isistan.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {

	public static void main(String[] args) {

		String driver = "org.apache.derby.jdbc.EmbeddedDriver";

		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(1);
		}

		String uri = "jdbc:derby:MyDerbyDb;create=true";

		try {
			Connection conn = DriverManager.getConnection(uri);
			createTable(conn);
			addPersona(conn, 1, "Johana", 31);
			addPersona(conn, 2, "Juan", 20);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addPersona(Connection conn, int id, String name, int year) throws SQLException {
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, year);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	private static void createTable(Connection conn) throws SQLException {
		String table = "CREATE TABLE persona("+
				"id INT,"+
				"nombre VARCHAR(500),"+
				"edad INT,"+
				"PRIMARY KEY(ID))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}

}
