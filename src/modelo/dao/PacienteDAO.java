package modelo.dao;

import java.sql.ResultSet;

import modelo.dto.PacienteDTO;
import util.ConexionPostgres;

public class PacienteDAO {
	
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

}
