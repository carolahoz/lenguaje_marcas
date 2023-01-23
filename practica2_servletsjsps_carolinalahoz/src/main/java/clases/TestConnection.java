package clases;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * Descarga de drivers:
 * https://docs.microsoft.com/es-es/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
 * 
 * CREAR TABLA TB_PERSONAS con los campos ID (VARCHAR), NAME (VARCHAR) y AGE (NUMERIC)
 */
public class TestConnection {
	
	public static void main(String[] args) {
		String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=dam1;"
//                        + "user=testuser;"
//                        + "password=testpassword;"
                       // + "encrypt=true;"
                        //Para autenticación con Windows
                        + "integratedSecurity=true;"
                        + "trustServerCertificate=true;";
                       // + "loginTimeout=10;";
		
		Connection connection = UtilsBD.getConnection(connectionUrl);
		
//		if(connection!=null) {
//			PersonasDAO personaDAO = new PersonasDAO(connection);
//			//Inserto personas en la base de datos
//			personaDAO.insertarPersonas();
//			//Consulto las personas de la base de datos y las pinto
//			personaDAO.printPersonas();
//			
//			//Cierro la conexion de la base de datos
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.err.println("Error al cerrar la conexion");
//				e.printStackTrace();
//			}
//		}
       
	}	
}
