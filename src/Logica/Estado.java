//import java.sql.Date;
package Logica;

import java.sql.Date;

public abstract class Estado {

	private java.util.Date fecha;
	private Sede sede;
	private String descripcion;
	private Empleado empleado;

	public Estado(Sede sede, java.util.Date fecha, String descripcion, Empleado empleado) {
		super();
		this.sede = sede;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.empleado = empleado;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
