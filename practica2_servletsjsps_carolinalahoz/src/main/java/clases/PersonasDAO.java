package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import utils.Persona;

/**
 * Clase para gestionar los datos de la tabla TB_PERSONAS
 * @author josel
 *
 */
public class PersonasDAO {
	private Connection connection;

	public PersonasDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insertarPersonas(Persona persona) throws SQLException{
		insertarPersonas(persona.getId(),persona.getNombre(),persona.getApellidos(), persona.getSaldo());
	}
	
	public void insertarPersonas(String id, String nombre, String apellidos, int saldo) throws SQLException{
		String insertQuery = "INSERT INTO TB_CLIENTES VALUES ( ?, ?, ?, ?)";
		
        PreparedStatement psInsert;
        
		psInsert = connection.prepareStatement(insertQuery);
        psInsert.setString(1, id);
        psInsert.setString(2, nombre);
        psInsert.setString(3, apellidos);
        psInsert.setInt(4, saldo);
        
        System.out.println("Insertando registro");
        psInsert.executeUpdate();
        System.out.println("Registro insertado");
	        
		
        System.out.println("Added another row of test data to the database");
	}
	
	public void insertarPersonas2(Persona2 persona) throws SQLException{
		insertarPersonas2(persona.getId(),persona.getUsuario(),persona.getPassword(), persona.getTipo());
	}
	
	public void insertarPersonas2(String id, String usuario, String password, String tipo) throws SQLException{
		String insertQuery = "INSERT INTO TB_USUARIOS VALUES ( ?, ?, ?, ?)";
		
        PreparedStatement psInsert;
        
		psInsert = connection.prepareStatement(insertQuery);
        psInsert.setString(1, id);
        psInsert.setString(2, usuario);
        psInsert.setString(3, password);
        psInsert.setString(4, tipo);
        
        System.out.println("Insertando registro");
        psInsert.executeUpdate();
        System.out.println("Registro insertado");
	        
		
        System.out.println("Added another row of test data to the database");
	}
	
}
