package Logica;
import java.sql.Date;
import java.util.ArrayList;

public class Alquiler extends Estado{

	private Cliente cliente;
	private java.util.Date fechaEntrega;
	private double tarifa;
	private Sede sedeEntrega;
	private Vehiculo vehiculo;
	private Seguro seguro;
	private ArrayList<Conductor> conductoresAdicionales;
	
	public Alquiler( Cliente cliente, Sede sede, java.util.Date fechaEntrega, Sede sedeEntrega, Vehiculo vehiculo, Seguro seguro,
			ArrayList<Conductor> conductoresAdicionales, java.util.Date fecha, Empleado reportador) {
		super(sede, fecha, null, reportador);
		this.cliente = cliente;
		this.fechaEntrega = fechaEntrega;
//		########### modificar tarifa
		this.tarifa = tarifa;
		this.sedeEntrega = sedeEntrega;
		this.vehiculo = vehiculo;
		this.seguro = seguro;
		this.conductoresAdicionales = conductoresAdicionales;
	}

	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Sede getSedeEntrega() {
		return sedeEntrega;
	}

	public void setSedeEntrega(Sede sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public ArrayList<Conductor> getConductoresAdicionales() {
		return conductoresAdicionales;
	}

	public void setConductoresAdicionales(ArrayList<Conductor> conductoresAdicionales) {
		this.conductoresAdicionales = conductoresAdicionales;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
