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
	
	public ArrayList<DiagnosticoDTO> listarDiagnostico(){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="select * from diagnostico";			
		ResultSet resultado=conexion.consultaSQL(consulta);
		ArrayList<DiagnosticoDTO> diagnosticosLista=new ArrayList<DiagnosticoDTO>();
		try {		
			while(resultado.next()){
				DiagnosticoDTO diagnostico=new DiagnosticoDTO();
				diagnostico.setId(resultado.getInt("id"));
				diagnostico.setNombre(resultado.getString("nombre"));
				diagnostico.setCodigo(resultado.getString("codigo"));
				diagnosticosLista.add(diagnostico);
			}			
			conexion.desconectar();
			return diagnosticosLista;
		} catch (SQLException e) {
			e.printStackTrace();	
			conexion.desconectar();
			return null;
		}
	}

}
