package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dto.DiagnosticoDTO;
import modelo.dto.PacienteDTO;
import util.ConexionPostgres;

public class PacienteDAO {
	public boolean actualizarPaciente
	(DiagnosticoDTO diagnostico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="update diagnostico set nombrte='"+diagnostico.getNombre()+"',codigo='"+diagnostico.getCodigo()+"' where id='"+diagnostico.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean crearPaciente(PacienteDTO paciente){
		
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta= "insert into paciente (nombre,cedula,telefono,direccion,celular)values ('"+paciente.getNombre()+"','"+paciente.getCedula()+"','"+paciente.getTelefono()+"', '"+paciente.getDireccion()+"','"+paciente.getCelular()+"')";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();
		if (resultado==null){
			return false;
		}else{
			return true;
		}
		
		
		
	}
	public boolean eliminarPaciente(PacienteDTO paciente){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="delete from paciente where id='"+paciente.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public ArrayList<PacienteDTO> listarPacienteDTOs(){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="select * from paciente";			
		ResultSet resultado=conexion.consultaSQL(consulta);
		ArrayList<PacienteDTO> pacienteList=new ArrayList<PacienteDTO>();
		try {		
			while(resultado.next()){
				PacienteDTO paciente=new PacienteDTO();
				paciente.setId(resultado.getInt("id"));
				paciente.setNombre(resultado.getString("nombre"));
				paciente.setCedula(resultado.getString("cedula"));
				paciente.setCelular (resultado.getString("celular"));
				paciente.setDireccion(resultado.getString("direccion"));
				paciente.setTelefono(resultado.getString(" telefono"));
				
				pacienteList.add(paciente);
			}			
			conexion.desconectar();
			return pacienteList;
		} catch (SQLException e) {
			e.printStackTrace();	
			conexion.desconectar();
			return null;
		}
	}

}
