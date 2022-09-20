package edu.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.example.db.ConnectionDB;
import edu.example.model.Persona;
/**
 * 
 * @author ChoySs
 *
 */
public class PersonaDAOImplementacion implements PersonaDAO<Persona> {

	final String INSERT = "INSERT INTO persona (id, nombre, edad) VALUES (?,?,?)";
	final String UPDATE = "UPDATE persona SET name = ?, year = ? WHERE id = ?";
	final String DELETE = "DELETE FROM persona WHERE id = ?";
	final String GETALL = "SELECT * FROM persona";
	final String GETONE = "SELECT * FROM persona WHERE id = ?"; 

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

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
	
	public PersonaDAOImplementacion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Persona get(int id) {
		Persona p = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(GETONE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				p = new Persona();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setYear(rs.getInt("year"));
				
			}else{
				System.out.println("No Employee found with id="+id);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		return p;
	}

	@Override
	public List<Persona> getAll() {
		List<Persona>personas = new ArrayList<>();
		try{
			conn = getConnection();
			ps = conn.prepareStatement(GETALL);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Persona p = new Persona();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setYear(rs.getInt("year"));
				
				personas.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		return personas;
	}

	@Override
	public void insert(Persona t) {
		try {
			conn = getConnection();
			ps = conn.prepareStatement(INSERT);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getYear());
			ps.executeUpdate();
			System.out.println("Datos agregados con éxito");
			//			rs = ps.getGeneratedKeys();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
				close(ps);
		}
	}

	@Override
	public void update(Persona t) {
		try{
			conn = getConnection();
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, t.getName());
			ps.setInt(2, t.getYear());
			ps.setInt(3, t.getId());
			ps.executeUpdate();
			System.out.println("Tabla actualizada con éxito"); 
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}

	}

	@Override
	public void delete(int id) {
		try{
			conn = getConnection();
			ps = conn.prepareStatement(DELETE);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Datos eliminados con éxito"); 
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
	}
	/**
	 * Cerrar una declaracion abierta
	 * @param ps Declaracion
	 */
	private static void close(Statement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				 e.printStackTrace();
			}
		}
	}

	
	
}
