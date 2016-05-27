package modelo.dto;

import java.util.Date;

public class FolioDTO {
	
	int id;	
	PacienteDTO paciente;
	Date fecha;
	String motivoConsulta;
	MedicoDTO medico;
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
	public MedicoDTO getMedico() {
		return medico;
	}
	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}
	
	
	
	

}
