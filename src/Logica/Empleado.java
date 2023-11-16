package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Empleado extends Usuario {
	
	private String usuario;
	private String contraseña;
	private String nombre;
	private Rol rol;
	private Sede sede;

	public Empleado(String usuario, String contraseña, String nombre, Rol rol, Sede sede) {
		super(usuario, contraseña, nombre);
		this.rol = rol;
		this.sede = sede;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public void crearAlquiler(Cliente cliente,Sede sedeRecogida, java.util.Date fechaEntrega, Sede sedeEntrega, Vehiculo vehiculo, Seguro seguro, ArrayList<Conductor> conductores, java.util.Date fechaRecogida) {

		Alquiler nuevoAlquiler = new Alquiler(cliente, sedeRecogida , fechaEntrega, sedeEntrega, vehiculo, seguro, conductores, fechaRecogida,this);
		vehiculo.setEstadoActual(nuevoAlquiler);
		cliente.agregarAlquiler(nuevoAlquiler);
//		nuevoAlquiler.getCliente().eliminarReserva(reserva);
//		nuevoAlquiler.getSede().eliminarReservaPendiente(reserva);
	}
	
}
