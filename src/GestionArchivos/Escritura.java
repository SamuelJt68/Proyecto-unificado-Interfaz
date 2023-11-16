package GestionArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import Logica.AdminLocal;
import Logica.Administrador;
import Logica.Alquiler;
import Logica.Categoria;
import Logica.Cliente;
import Logica.Conductor;
import Logica.Empleado;
import Logica.Estado;
import Logica.Reserva;
import Logica.Sede;
import Logica.Seguro;
import Logica.Vehiculo;

public class Escritura{

	public Escritura() {
		
	}

	public void escribirClientes(ArrayList<Cliente> clientes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Clientes.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Cliente cliente : clientes)
		{
			pw.println(cliente.getUsuario() + ";" + cliente.getContraseña() + ";" + cliente.getNombre()+ ";" + cliente.getFechaNacimiento().getDate() + ";" + cliente.getFechaNacimiento().getMonth() + ";" + cliente.getFechaNacimiento().getYear() + ";" + cliente.getNacionalidad() + ";" + cliente.getDatosContacto().getDiereccion() + ";" + cliente.getDatosContacto().getEmail() + ";" + cliente.getDatosContacto().getTelefono() + ";" + cliente.getDatosLicencia().getNumero() + ";" + cliente.getDatosLicencia().getPaisExpedicion() + ";" + cliente.getDatosLicencia().getFechaVencimiento().getDate() + ";" + cliente.getDatosLicencia().getFechaVencimiento().getMonth() + ";" + cliente.getDatosLicencia().getFechaVencimiento().getYear() + ";" + cliente.getDatosPago().getNumeroTarjeta() + ";" + cliente.getDatosPago().getCvv() + ";" + cliente.getDatosPago().getExpiracion());
		}
		pw.close();
	}
	
	public void escribirReservas(ArrayList<Cliente> clientes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Reservas.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Cliente cliente : clientes)
		{
			for (Reserva res : cliente.getReservas())
			{
				pw.println(res.getCliente().getUsuario() + ";" + res.getCategoria().getNombre() + ";" + res.getTarifa() + ";" + res.getSedeRecogida().getNombre() + ";" + res.getFechaRecogida().getDate() + ";" + res.getFechaRecogida().getMonth() + ";" + res.getFechaRecogida().getYear() + ";" + res.getFechaRecogida().getHours() + ";" + res.getSedeEntrega().getNombre() + ";" + res.getFechaEntrega().getDate() + ";" + res.getFechaEntrega().getMonth() + ";" + res.getFechaEntrega().getYear() + ";" + res.getFechaEntrega().getHours());
			}
		}
		pw.close();
	}
	
	public void escribirEmpleados(ArrayList<Sede> sedes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Empleados.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Sede sede : sedes)
		{
			for (Empleado empleado : sede.getEmpleados())
			{
				pw.println(empleado.getUsuario() + ";" + empleado.getContraseña() + ";" + empleado.getNombre() + ";" + empleado.getRol() + ";" + empleado.getSede().getNombre());
			}
		}
		pw.close();
	}
	
	public void escribirAdministradores(ArrayList<Sede> sedes, Administrador administrador) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Administradores.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		pw.println(administrador.getUsuario() + ";" + administrador.getContraseña() + ";" + administrador.getNombre());
		for (Sede sede : sedes)
		{
			AdminLocal admin = sede.getAdmin();
			
			pw.println(admin.getUsuario() + ";" + admin.getContraseña() + ";" + admin.getNombre() + ";" + admin.getSede().getNombre());
		}
		pw.close();
	}
	
	public void escribirSedes(ArrayList<Sede> sedes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Sedes.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Sede sede : sedes)
		{
				pw.println(sede.getNombre() + ";" + sede.getDireccion() + ";" + sede.getHorarios());
		}
		pw.close();
	}
	
	public void escribirAlquileres(ArrayList<Cliente> clientes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Alquileres.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Cliente cliente : clientes)
		{
			for (Alquiler alqui : cliente.getAlquileres())
			{
				pw.println(alqui.getCliente().getUsuario() + ";" + alqui.getSede().getNombre() + ";" + alqui.getFecha().getDate() + ";" + alqui.getFecha().getMonth() + ";" + alqui.getFecha().getYear() + ";" + alqui.getFecha().getHours() + ";" + alqui.getSedeEntrega().getNombre() + ";" + alqui.getFechaEntrega().getDate() + ";" + alqui.getFechaEntrega().getMonth() + ";" + alqui.getFechaEntrega().getYear() + ";" + alqui.getFechaEntrega().getHours() + ";" + alqui.getVehiculo().getPlaca() + ";" + alqui.getSeguro().getNombre());
			}
		}
		pw.close();
	}
	
	public void escribirConductores(ArrayList<Cliente> clientes) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Conductores.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Cliente cliente : clientes)
		{
			for (Alquiler alqui : cliente.getAlquileres())
			{
				for(Conductor con : alqui.getConductoresAdicionales())
				{
					pw.println(con.getUsuario() + ";" + con.getContraseña() + ";" + con.getNombre() + ";" + con.getDatosContacto().getDiereccion() + ";" + con.getDatosContacto().getEmail() + ";" + con.getDatosContacto().getTelefono() + ";" + con.getDatosLicencia().getNumero() + ";" + con.getDatosLicencia().getPaisExpedicion() + ";" + con.getDatosLicencia().getFechaVencimiento().getDate() + ";" + con.getDatosLicencia().getFechaVencimiento().getMonth() + ";" + con.getDatosLicencia().getFechaVencimiento().getYear() + ";" + con.getVehiculo().getPlaca());
				}
			}
		}
		pw.close();
	}
	
	public void escribirVehiculos(ArrayList<Vehiculo> vehiculos) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Vehiculos.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Vehiculo vehiculo : vehiculos)
		{
				pw.println(vehiculo.getPlaca() + ";" + vehiculo.getMarca() + ";" + vehiculo.getModelo() + ";" + vehiculo.getColor() + ";" + vehiculo.getCapacidad() + ";" + vehiculo.getTipoTransmision() + ";" + vehiculo.getCategoria().getNombre());
		}
		pw.close();
	}
	
	public void escribirSeguros(ArrayList<Seguro> seguros) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Seguros.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Seguro seguro : seguros)
		{
				pw.println(seguro.getNombre() + ";" + seguro.getCostoDiario());
		}
		pw.close();
	}
	
	public void escribirCategorias(ArrayList<Categoria> categorias) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Categorias.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Categoria cat : categorias)
		{
				pw.println(cat.getNombre() + ";" + cat.getGamma() + ";" + cat.getTarifaAlta() + ";" + cat.getTarifaBaja() + ";" + cat.getExtraSede() + ";" + cat.getExtraConductor());
		}
		pw.close();
	}
	
	public void escribirEstados(ArrayList<Vehiculo> vehiculos) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileOutputStream os = new FileOutputStream(new File("data\\Estados.csv"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		for (Vehiculo vehiculo : vehiculos)
		{
			for (Estado est : vehiculo.getEstados())
			{
				pw.println(vehiculo.getPlaca() + ";" + est.getClass().getSimpleName() + ";" + est.getSede().getNombre() + ";" + est.getFecha().getDate() + ";" + est.getFecha().getMonth() + ";" + est.getFecha().getYear() + ";" + est.getFecha().getHours() + ";" + est.getDescripcion() + ";" + est.getEmpleado().getUsuario());
			}
		}
		pw.close();
	}
	
}
