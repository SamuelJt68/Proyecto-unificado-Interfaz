package Logica;

public class DatosPago {
	private String numeroTarjeta;
	private String expiracion;
	private String cvv;
	
	public DatosPago(String numeroTarjeta, String expiracion, String cvv) {
		this.numeroTarjeta = numeroTarjeta;
		this.expiracion = expiracion;
		this.cvv = cvv;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(String expiracion) {
		this.expiracion = expiracion;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
}
