package modelo.dto;

public class Procedimientos {
int Id;
String Nombre; 
String Codigo; 
Diagnostico diagnostico;
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
public Diagnostico getDiagnostico() {
	return diagnostico;
}
public void setDiagnostico(Diagnostico diagnostico) {
	this.diagnostico = diagnostico;
} 


}
