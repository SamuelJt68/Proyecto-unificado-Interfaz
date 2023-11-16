package Logica;
import java.sql.Date;

public class DatosLicencia {

	private String numero;
	private String paisExpedicion;
	private Date fechaVencimiento;
	
	public DatosLicencia(String numero, String pais, Date fecha) {
		this.numero = numero;
		this.paisExpedicion = pais;
		this.fechaVencimiento = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPaisExpedicion() {
		return paisExpedicion;
	}

	public void setPaisExpedicion(String paisExpedicion) {
		this.paisExpedicion = paisExpedicion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
}
