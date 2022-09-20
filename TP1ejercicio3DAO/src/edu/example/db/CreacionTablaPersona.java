package edu.example.db;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 
 * @author ChoySs
 *
 */
public class CreacionTablaPersona {

	private Connection conn = null;

	public CreacionTablaPersona() {
		super();
	}
/**
 * 
 * @return conexion a la base de datos
 * @throws SQLException
 */
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionDB.getInstance().getConnection();
		return conn;
	}
/**
 * Creacion de la tabla persona en la base de datos
 */
	public void CracionDB(){
		try {
			conn = getConnection();
			String table = "CREATE TABLE persona("+
					"id INT,"+
					"nombre VARCHAR(500),"+
					"edad INT,"+
					"PRIMARY KEY(ID))";
			conn.prepareStatement(table).execute();
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
