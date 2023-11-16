package Logica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class Empresa extends Cargar_Sede{

	private Administrador administrador;
	//	private ArrayList<Reserva> reservas;
    private ArrayList<Sede> sedes;
    private ArrayList<Categoria> categorias;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Seguro> seguros;
    private Usuario usuarioActual;

    public Empresa() {
        sedes = new ArrayList<Sede>();
        categorias = new ArrayList<Categoria>();
        vehiculos = new ArrayList<Vehiculo>();
        clientes = new ArrayList<Cliente>();
        seguros = new ArrayList<Seguro>();
    }

    public void agregarSede(Sede sede) {
    	sedes.add(sede);
	}
    
    public ArrayList<Sede> getSedes() {
		return sedes;
	}
    
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String usuario, String contraseña, String nombre) {
		
		this.administrador = new Administrador(usuario,contraseña,nombre,this);
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	
	public void agregarCategoria(Categoria categoria) {
    	categorias.add(categoria);
	}
		
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void nuevoCliente(String usuario, String contraseña, String nombre, Date fechaNacimiento, String nacionalidad,
			File imagenID, DatosContacto datosContacto, DatosLicencia datosLicencia, DatosPago datosPago) {
		Cliente nuevoCliente = new Cliente(usuario, contraseña, nombre, fechaNacimiento, nacionalidad, imagenID, datosContacto, datosLicencia, datosPago);
		clientes.add(nuevoCliente);
	}
	
	public ArrayList<Seguro> getSeguros(){
		return seguros;
	}
	
	public void agregarSeguro(Seguro seguro) {
		seguros.add(seguro);
	}
	
	public Usuario getUsuarioActual(){
        return usuarioActual;
    }
	
    public void setUsuarioActual(Usuario usuario){
        usuarioActual=usuario;
    }
}
