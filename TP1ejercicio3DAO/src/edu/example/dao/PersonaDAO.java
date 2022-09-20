package edu.example.dao;

import java.util.List;
/**
 * 
 * @author ChoySs
 *
 * @param <Persona>
 */
public interface PersonaDAO<Persona> {

	/**
	 * Devuelve la persona cuyo Identificador (id) coincida
	 * <br>Devuelve nulo si no existe ningun Identificador (id) de persona</br>
	 * 
	 * @param id Identificador de la persona
	 * @return persona cuyo id coincida o es nulo
	 */
	Persona get(int id);

	/**
	 * Obtiene todos las personas
	 * <br>Devuelve una lista de tamanio 0 si no hay datos</br>
	 * @return Todos los datos
	 */
	List<Persona> getAll();

	/**
	 * Registra una Persona especifica
	 * <br> tiene comentado metodo para establecer Identificador (id) unico cuando el registro sea exitoso
	 * @param t persona a registrar
	 */
	void insert(Persona t);

	/**
	 * Actualiza a la persona especificado id
	 * @param t Persona a actualizar
	 */
	void update(Persona t);

	/**
	 * Elimina a la persona con el Identificador (id) especificado
	 * @param t Identificador a eliminar
	 */
	void delete(int t);
}
