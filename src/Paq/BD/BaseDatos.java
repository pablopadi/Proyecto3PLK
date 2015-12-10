package Paq.BD;

import java.sql.*;

public class BaseDatos {
	
	Connection conn=null;
	{
	try
    {
      // create a database conn
      conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
      Statement statement = conn.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("create table Prota (municion integer, name_p string)");
      statement.executeUpdate("create table Enemigo (name_e string, num_e integer)");
      statement.executeUpdate("create table Juagdor (puntuacion integer, name_j string)");
      statement.executeUpdate("insert into Prota values(50, 'Leon')");
      statement.executeUpdate("insert into Enemigo values('Zombie', 1)");
      ResultSet rs = statement.executeQuery("select * from Prota");
      while(rs.next())
      {
        // read the result set
        System.out.println("name_p = " + rs.getString("name_p"));
        System.out.println("municion = " + rs.getInt("municion"));
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(conn != null)
          conn.close();
      }
      catch(SQLException e)
      {
        // conn close failed.
        System.err.println(e);
      }
    }
}
	}
//package ud.prog3.pr0304;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///** Métodos útiles para base de datos.
// * Clase con métodos estáticos para gestionar una sola base de datos
// * @author Andoni Eguíluz Morán
// * Facultad de Ingeniería - Universidad de Deusto
// */
//public class BaseDeDatos {
//
//	// ------------------------------------
//	// VALIDO PARA CUALQUIER BASE DE DATOS
//	// ------------------------------------
//	
//	private static Connection connection = null;
//	private static Statement statement = null;
//
//	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
//	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
//	 * @param nombreBD	Nombre de fichero de la base de datos
//	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
//	 */
//	public static Connection initBD( String nombreBD ) {
//		try {
//		    Class.forName("org.sqlite.JDBC");
//		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
//			statement = connection.createStatement();
//			statement.setQueryTimeout(30);  // poner timeout 30 msg
//		    return connection;
//		} catch (ClassNotFoundException | SQLException e) {
//			return null;
//		}
//	}
//	
//	/** Cierra la conexión con la Base de Datos
//	 */
//	public static void close() {
//		try {
//			statement.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
//	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
//	 */
//	public static Connection getConnection() {
//		return connection;
//	}
//	
//	/** Devuelve una sentencia para trabajar con la BD,
//	 * si la conexión si ha sido establecida previamente (#initBD()).
//	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
//	 */
//	public static Statement getStatement() {
//		return statement;
//	}
//
//	// ------------------------------------
//	// PARTICULAR DEL CATALOGO MULTIMEDIA
//	// ------------------------------------
//	
//	/** Crea una tabla de catálogo multimedia en una base de datos, si no existía ya.
//	 * Debe haberse inicializado la conexión correctamente.
//	 */
//	public static void crearTablaBD() {
//		if (statement==null) return;
//		try {
//			statement.executeUpdate("create table fichero_multimedia " +
//				"(fichero string, error boolean, titulo string" +
//				", cantante string, comentarios string)");
//		} catch (SQLException e) {
//			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
//			// e.printStackTrace();  
//		}
//	}
//
//}



