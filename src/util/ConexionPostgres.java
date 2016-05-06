package util;

import java.sql.*;

public class ConexionPostgres {
	
	String driver = "org.postgresql.Driver";
	String connectString = "jdbc:postgresql://localhost:5432/muelitas";
	String usuario="";
	String clave="";	
	Connection conexion;
	
	public boolean conectar(){
		
		try{
				Class.forName(driver);
				conexion=DriverManager.getConnection(connectString, usuario , clave);
				return true;

			}catch ( Exception e ){
				System.out.println(e.getMessage());
				return false;
			}
	}

	public boolean desconectar(){
		try{
			conexion.close();
			return true;

		}catch ( Exception e ){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public ResultSet consultaSQL(String consulta){		
		try{
			Statement stmt = conexion.createStatement();
			return stmt.executeQuery(consulta);	
		}catch ( Exception e ){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
