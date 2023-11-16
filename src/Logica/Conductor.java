package Logica;

public class Conductor extends Usuario {

	private DatosContacto datosContacto;
	private DatosLicencia datosLicencia;
	private Vehiculo vehiculo;
	
	public Conductor(String usuario, String contraseña, String nombre, DatosContacto datosContacto,
			DatosLicencia datosLicencia, Vehiculo vehiculo) {
		super(usuario, contraseña, nombre);
		this.datosContacto = datosContacto;
		this.datosLicencia = datosLicencia;
		this.vehiculo = vehiculo;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	public DatosLicencia getDatosLicencia() {
		return datosLicencia;
	}

	public void setDatosLicencia(DatosLicencia datosLicencia) {
		this.datosLicencia = datosLicencia;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
