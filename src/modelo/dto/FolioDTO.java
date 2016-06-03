package modelo.dto;

import java.util.Date;

public class FolioDTO {
	
	int id;	
	PacienteDTO paciente;
	int pacienteId;
	Date fecha;
	String motivoConsulta;
	MedicoDTO medico;
	int medicoId;
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
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	public int getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}
	
	
	
	

}
