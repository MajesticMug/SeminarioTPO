package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
	private static Connection conn;
	
	private static String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=centro_odontologico;integratedSecurity=true";
	
	public static Connection getInstancia() {
		if (conn == null) 
		{
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(connectionString);
			} catch (SQLException e)
			{
				// TODO: tirar excepcion "no se pudo conectar"
				e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
}
