package Logica;

public class Seguro {

	private String nombre;
	private double costoDiario;
	public Seguro(String nombre, double costoDiario) {
		super();
		this.nombre = nombre;
		this.costoDiario = costoDiario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCostoDiario() {
		return costoDiario;
	}
	public void setCostoDiario(double costoDiario) {
		this.costoDiario = costoDiario;
	}
	
}
