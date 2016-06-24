package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.dao.DiagnosticoDAO;
import modelo.dto.DiagnosticoDTO;

import org.junit.Test;

public class PruebaDiagnostico {
	
	DiagnosticoDAO diagnosticoDAO=new DiagnosticoDAO();
	
	@Test
	public void pruebaGuardarDiagnostico() {
		
		DiagnosticoDTO diagnostico=new DiagnosticoDTO();
		diagnostico.setNombre("hola mundo");
		diagnostico.setCodigo("001");
		assertEquals("probando guardar diagnostico", true, diagnosticoDAO.crearDiagnostico(diagnostico));
	}
	@Test
	public void pruebaActualizar() {
		
		DiagnosticoDTO diagnostico=new DiagnosticoDTO();
		diagnostico.setId(1);
		diagnostico.setNombre(" somos los mejores ");
		diagnostico.setCodigo("002");
		assertEquals("probando guardar diagnostico", true, diagnosticoDAO.actualizarDiagnostico(diagnostico));
	}
	@Test
	public void pruebaEliminar() {
		
		DiagnosticoDTO diagnostico=new DiagnosticoDTO();
		diagnostico.setId(2);
		assertEquals("probando guardar diagnostico", true, diagnosticoDAO.eliminarDiagnostico(diagnostico));
	}
	
	@Test
	public void pruebaListar() {
		ArrayList<DiagnosticoDTO> lista = diagnosticoDAO.listarDiagnostico();
		int tam=lista.size();
		boolean error=false;
		for(int i=0;i<tam;i++){
			DiagnosticoDTO diagnostico = lista.get(i);
			System.out.println("Id:"+diagnostico.getId()+" Nombre:"+diagnostico.getNombre());
			error=true;
		}
		assertEquals("probando guardar diagnostico", true,error);
	}
}
