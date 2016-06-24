package pruebas;

import static org.junit.Assert.*;

import modelo.dao.DiagnosticoDAO;
import modelo.dao.PacienteDAO;
import modelo.dto.DiagnosticoDTO;
import modelo.dto.PacienteDTO;

import org.junit.Test;

public class PruebaPaciente {

PacienteDAO pacienteDAO=new PacienteDAO();
	
	@Test
	public void pruebaGuardarPaciente() {
		
		PacienteDTO paciente=new PacienteDTO();
		paciente.setCedula("1111111111");
		assertEquals("probando guardar diagnostico", true,  pacienteDAO.crearPaciente(paciente));
	}

}
