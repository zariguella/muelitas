package modelo.dto;

public class ProcedimientoDTO {
int Id;
String Nombre; 
String Codigo; 
DiagnosticoDTO diagnostico;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getCodigo() {
	return Codigo;
}
public void setCodigo(String codigo) {
	Codigo = codigo;
}
public DiagnosticoDTO getDiagnostico() {
	return diagnostico;
}
public void setDiagnostico(DiagnosticoDTO diagnostico) {
	this.diagnostico = diagnostico;
} 


}
