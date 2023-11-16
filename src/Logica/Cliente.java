package Logica;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private Date fechaNacimiento;
	private String nacionalidad;
	private File imagenID;
	private DatosContacto datosContacto;
	private DatosLicencia datosLicencia;
	private DatosPago datosPago;
	private ArrayList<Reserva> reservas;
	private ArrayList<Alquiler> alquileres;
	
	public Cliente(String usuario, String contraseña, String nombre, Date fechaNacimiento, String nacionalidad,
			File imagenID, DatosContacto datosContacto, DatosLicencia datosLicencia, DatosPago datosPago) {
		super(usuario, contraseña, nombre);
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.imagenID = imagenID;
		this.datosContacto = datosContacto;
		this.datosLicencia = datosLicencia;
		this.datosPago = datosPago;
		reservas = new ArrayList<Reserva>();
		alquileres = new ArrayList<Alquiler>();
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public File getImagenID() {
		return imagenID;
	}

	public void setImagenID(File imagenID) {
		this.imagenID = imagenID;
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

	public DatosPago getDatosPago() {
		return datosPago;
	}

	public void setDatosPago(DatosPago datosPago) {
		this.datosPago = datosPago;
	}
	
	public ArrayList<Reserva> getReservas(){
		return reservas;
	}
	
	public void crearReserva (java.util.Date fechaRecogida, java.util.Date fechaEntrega, double tarifa, Categoria categoria,Sede sedeRecogida, Sede sedeEntrega) {
		Reserva nuevaReserva = new Reserva(fechaRecogida, fechaEntrega, tarifa, this, categoria, sedeRecogida, sedeEntrega);
		reservas.add(nuevaReserva);
		sedeEntrega.agregarReservaPendiente(nuevaReserva);
	}
	
	public void modificarReserva(Reserva reserva, Date nuevaFecha) {
		reserva.setFechaEntrega(nuevaFecha);
	}
	
	public void eliminarReserva(Reserva reserva) {
		reservas.remove(reservas.indexOf(reserva));
	}

	public ArrayList<Alquiler> getAlquileres(){
		return alquileres;
	}
	
	public void agregarAlquiler(Alquiler alquiler) {
		alquileres.add(alquiler);
	}
	
}
