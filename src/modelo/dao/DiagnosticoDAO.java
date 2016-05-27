package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dto.DiagnosticoDTO;

import util.ConexionPostgres;

public class DiagnosticoDAO {
	
	public boolean crearDiagnostico(DiagnosticoDTO diagnostico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="insert into diagnostico(nombre,codigo)values('"+diagnostico.getNombre()+"','"+diagnostico.getCodigo()+"')";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean eliminarDiagnostico(DiagnosticoDTO diagnostico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="delete from diagnostico where id='"+diagnostico.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public ArrayList<DiagnosticoDTO> listarDiagnostico(DiagnosticoDTO diagnostico){
		try {
			ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
			conexion.conectar();
			String consulta="select * from diagnostico";			
			ResultSet resultado=conexion.consultaSQL(consulta);			
				while(resultado.next()){
					
				}			
			conexion.desconectar();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
