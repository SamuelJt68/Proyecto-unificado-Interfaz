package Logica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Administrador extends Empleado{

	private String usuario;
	private String contraseña;
	private String nombre;
	private Rol rol;
	private Empresa empresa;
	
	public Administrador(String usuario, String contraseña, String nombre, Empresa empresa) {
		super(usuario, contraseña, nombre, Rol.ADMINISTRADOR, null);
		this.empresa = empresa; 
	}
	
	public void asignarAdminLocal(String usuario, String contraseña, String nombre, Sede sede) {
		AdminLocal nuevoAdminLocal = new AdminLocal(usuario, contraseña, nombre, sede);
		sede.setAdmin(nuevoAdminLocal);
	}
	
	public void crearSede(String nombre, String direccion, String horarios, AdminLocal admin) {
        Sede nuevaSede = new Sede(nombre, direccion, horarios, admin);
        empresa.agregarSede(nuevaSede);
    }
	
	public void crearCategoria(String nombre, String gamma, double tarifaAlta, double tarifaBaja, double extraSede,
			double extraConductor) {
		Categoria nuevaCategoria = new Categoria(nombre, gamma, tarifaAlta, tarifaBaja, extraSede, extraConductor) ;
		empresa.agregarCategoria(nuevaCategoria);
	}
	
	public void crearVehiculo(String placa, String marca, String modelo, String color, String tipoTransmision, int capacidad,
			Categoria categoria) {
		Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, modelo, color, tipoTransmision, capacidad, categoria);
		empresa.agregarVehiculo(nuevoVehiculo);
	}
	
	public void crearSeguro(String nombre, double costoDiario) {
		Seguro nuevoSeguro = new Seguro(nombre, costoDiario);
		empresa.agregarSeguro(nuevoSeguro);
	}
	
}
