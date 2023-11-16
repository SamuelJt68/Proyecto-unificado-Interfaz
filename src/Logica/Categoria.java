package Logica;

public class Categoria {

	private String nombre;
	private String gamma;
	private double tarifaAlta;
	private double tarifaBaja;
	private double extraSede;
	private double extraConductor;
	
	public Categoria(String nombre, String gamma, double tarifaAlta, double tarifaBaja, double extraSede,
			double extraConductor) {
		super();
		this.nombre = nombre;
		this.gamma = gamma;
		this.tarifaAlta = tarifaAlta;
		this.tarifaBaja = tarifaBaja;
		this.extraSede = extraSede;
		this.extraConductor = extraConductor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGamma() {
		return gamma;
	}
	public void setGamma(String gamma) {
		this.gamma = gamma;
	}
	public double getTarifaAlta() {
		return tarifaAlta;
	}
	public void setTarifaAlta(double tarifaAlta) {
		this.tarifaAlta = tarifaAlta;
	}
	public double getTarifaBaja() {
		return tarifaBaja;
	}
	public void setTarifaBaja(double tarifaBaja) {
		this.tarifaBaja = tarifaBaja;
	}
	public double getExtraSede() {
		return extraSede;
	}
	public void setExtraSede(double extraSede) {
		this.extraSede = extraSede;
	}
	public double getExtraConductor() {
		return extraConductor;
	}
	public void setExtraConductor(double extraConductor) {
		this.extraConductor = extraConductor;
	}
	
}
