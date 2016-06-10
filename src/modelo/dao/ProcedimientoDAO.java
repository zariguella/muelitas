package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dto.DiagnosticoDTO;
import modelo.dto.ProcedimientoDTO;
import util.ConexionPostgres;



public class ProcedimientoDAO {
	public boolean actualizarProcedimiento(ProcedimientoDTO procedimiento){
			ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
			conexion.conectar();
			String consulta="update procedimiento set nombre='"+procedimiento.getNombre()+"',codigo='"+procedimiento.getCodigo()+"' where id='"+procedimiento.getId()+"'";
			ResultSet resultado=conexion.consultaSQL(consulta);
			conexion.desconectar();	
			if(resultado==null){
				return false;
			}else{
				return true;
			}		
		}
	public boolean crearPaciente(ProcedimientoDTO procedimiento){
		
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta= "insert into procedimiento (id, codigo, nombre, diagnostico_id)values ('"+procedimiento.getId()+"','"+procedimiento.getCodigo()+"','"+procedimiento.getNombre()+"', '"+procedimiento.getDiagnosticoId()+"')";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();
		if (resultado==null){
			return false;
		}else{
			return true;
		}
		
		
		
	}
	public boolean eliminarProcedimiento(ProcedimientoDTO procedimiento){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="delete from procedimiento where id='"+procedimiento.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public ArrayList<ProcedimientoDTO> listaProcedimientoDTOs(){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="select * from procedimiento";			
		ResultSet resultado=conexion.consultaSQL(consulta);
		ArrayList<ProcedimientoDTO> procedimientoLista=new ArrayList<ProcedimientoDTO>();
		try {		
			while(resultado.next()){
				ProcedimientoDTO procedimiento=new ProcedimientoDTO();
				procedimiento.setId(resultado.getInt("id"));
				procedimiento.setNombre(resultado.getString("nombre"));
				procedimiento.setCodigo(resultado.getString("codigo"));
				procedimiento.setDiagnosticoId(resultado.getInt("diagnostico_id"));
				
				
				procedimientoLista.add(procedimiento);
			}			
			conexion.desconectar();
			return procedimientoLista;
		} catch (SQLException e) {
			e.printStackTrace();	
			conexion.desconectar();
			return null;
		}
	}

}
