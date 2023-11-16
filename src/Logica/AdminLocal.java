package Logica;

public class AdminLocal extends Empleado{
	
	public AdminLocal(String usuario, String contraseña, String nombre, Sede sede) {
		super(usuario, contraseña, nombre, Rol.ADMINISTRADORLOCAL, sede);
	}	
	
	public void crearEmpleado(String usuario, String contraseña, String nombre, Rol rol, Sede sede) {
		Empleado nuevoEmpleado = new Empleado(usuario,contraseña,nombre,rol,sede);
		sede.añadirEmpleado(nuevoEmpleado);
	}
	
}
