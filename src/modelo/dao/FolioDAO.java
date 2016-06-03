package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dto.FolioDTO;
import util.ConexionPostgres;

public class FolioDAO {
	public boolean crearFolio(FolioDTO folio){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="insert into folio(paciente_id,motivo,medico_id)values('"+folio.getPacienteId()+"','"+folio.getMotivoConsulta()+"','"+folio.getMedicoId()+"')";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean actualizarFolio(FolioDTO folio){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="update folio set paciente_id='"+folio.getPacienteId()+"',motivo='"+folio.getMotivoConsulta()+"',medico_id='"+folio.getMedicoId()+"' where id='"+folio.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean eliminarFolio(FolioDTO folio){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="delete from folio where id='"+folio.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public ArrayList<FolioDTO> listarFolio(){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="select * from folio";			
		ResultSet resultado=conexion.consultaSQL(consulta);
		ArrayList<FolioDTO> foliosLista=new ArrayList<FolioDTO>();
		try {		
			while(resultado.next()){
				FolioDTO folio=new FolioDTO();
				folio.setId(resultado.getInt("id"));
				folio.setPacienteId(resultado.getInt("paciente_id"));
				folio.setMotivoConsulta(resultado.getString("motivo"));
				folio.setMedicoId(resultado.getInt("medico_id"));
				foliosLista.add(folio);
			}			
			conexion.desconectar();
			return foliosLista;
		} catch (SQLException e) {
			e.printStackTrace();	
			conexion.desconectar();
			return null;
		}
	}

}
