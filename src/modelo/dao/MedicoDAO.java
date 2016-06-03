package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dto.MedicoDTO;
import util.ConexionPostgres;

public class MedicoDAO {
	public boolean crearMedico(MedicoDTO medico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="insert into medico(nombre,telefono,registro)values('"+medico.getNombre()+"','"+medico.getTelefono()+"','"+medico.getRegistroMedico()+"')";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean actualizarMedico(MedicoDTO medico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="update medico set nombrte='"+medico.getNombre()+"',telefono='"+medico.getTelefono()+"',telefono='"+medico.getRegistroMedico()+"' where id='"+medico.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public boolean eliminarMedico(MedicoDTO medico){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="delete from medico where id='"+medico.getId()+"'";
		ResultSet resultado=conexion.consultaSQL(consulta);
		conexion.desconectar();	
		if(resultado==null){
			return false;
		}else{
			return true;
		}		
	}
	
	public ArrayList<MedicoDTO> listarMedico(){
		ConexionPostgres conexion=ConexionPostgres.obtenerInstancia();
		conexion.conectar();
		String consulta="select * from medico";			
		ResultSet resultado=conexion.consultaSQL(consulta);
		ArrayList<MedicoDTO> medicosLista=new ArrayList<MedicoDTO>();
		try {		
			while(resultado.next()){
				MedicoDTO medico=new MedicoDTO();
				medico.setId(resultado.getInt("id"));
				medico.setNombre(resultado.getString("nombre"));
				medico.setTelefono(resultado.getString("telefono"));
				medicosLista.add(medico);
			}			
			conexion.desconectar();
			return medicosLista;
		} catch (SQLException e) {
			e.printStackTrace();	
			conexion.desconectar();
			return null;
		}
	}
}
