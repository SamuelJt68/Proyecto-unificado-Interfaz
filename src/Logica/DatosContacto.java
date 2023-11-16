package Logica;

public class DatosContacto {

	private String telefono;
	private String diereccion;
	private String email;
	public DatosContacto(String telefono, String diereccion, String email) {
		this.telefono = telefono;
		this.diereccion = diereccion;
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiereccion() {
		return diereccion;
	}
	public void setDiereccion(String diereccion) {
		this.diereccion = diereccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
