package modelo.dto;

import java.util.Date;

public class Folio {
	
	int id;	
	PacienteDTO paciente;
	Date fecha;
	String motivoConsulta;
	Medico medico;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PacienteDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
	

}
