package pruebas;

import static org.junit.Assert.*;

import modelo.dao.DiagnosticoDAO;
import modelo.dto.DiagnosticoDTO;

import org.junit.Test;

public class PruebaDiagnostico {
	
	DiagnosticoDAO diagnosticoDAO=new DiagnosticoDAO();
	
	@Test
	public void pruebaGuardarDiagnostico() {
		
		DiagnosticoDTO diagnostico=new DiagnosticoDTO();
		diagnostico.setNombre("dolor de muela");
		diagnostico.setCodigo("001");
		assertEquals("probando guardar diagnostico", true, diagnosticoDAO.crearDiagnostico(diagnostico));
	}

}
