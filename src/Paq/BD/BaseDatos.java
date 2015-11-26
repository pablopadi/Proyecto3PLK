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



