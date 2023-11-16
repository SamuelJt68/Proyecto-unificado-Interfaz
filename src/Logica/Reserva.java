package Logica;
import java.sql.Date;

public class Reserva {

	private java.util.Date fechaRecogida;
	private java.util.Date fechaEntrega;
	private double tarifa;
	private Cliente cliente;
	private Categoria categoria;
	private Sede sedeRecogida;
	private Sede sedeEntrega;
	
	public Reserva(java.util.Date fechaRecogida, java.util.Date fechaEntrega, double tarifa, Cliente cliente, Categoria categoria,
			Sede sedeRecogida, Sede sedeEntrega) {
		super();
		this.fechaRecogida = fechaRecogida;
		this.fechaEntrega = fechaEntrega;
		this.tarifa = tarifa;
		this.cliente = cliente;
		this.categoria = categoria;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
	}
	
	public java.util.Date getFechaRecogida() {
		return fechaRecogida;
	}
	
	public void setFechaRecogida(java.util.Date fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	
	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public double getTarifa() {
		return tarifa;
	}
	
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Sede getSedeRecogida() {
		return sedeRecogida;
	}
	
	public void setSedeRecogida(Sede sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}
	
	public Sede getSedeEntrega() {
		return sedeEntrega;
	}
	
	public void setSedeEntrega(Sede sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}
	
}
