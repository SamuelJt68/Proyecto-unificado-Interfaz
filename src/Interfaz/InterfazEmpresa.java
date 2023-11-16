package Interfaz;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import ControladorSesion.Seguridad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


import GestionArchivos.Carga;
import GestionArchivos.Comparador;
import GestionArchivos.Escritura;
import Logica.DatosContacto;
import Logica.DatosLicencia;
import Logica.DatosPago;
import Logica.Empresa;
import Logica.Sede;


public class InterfazEmpresa extends JFrame implements WindowListener {
	
	private JPanel contenPanel; 
	private VistaMenuInicial vistaMenuInicial;
	private VistaInicioSesion vistaInicioSesion;
	private VistaInicioSesionCliente vistaInicioSesionCliente;
	private VistaMenuEmpleado vistaMenuEmpleado;
	private VistaNuevaCuenta vistaNuevaCuenta;
	private VistaMenuCliente vistaMenuCliente;
	private VistaNuevaReserva vistaNuevaReserva;
	private VistaHistorial vistaHistorial;
	private VistaDispo vistaDispo;
	private VistaRealizarPago vistaRealizarPago;
	private VistaAdmiLocal vistaAdmiLocal;
	private VistaCrearCategoria vistaCrearCategoria;
	private VistaModCategoria vistaModCategoria;
	private VistaCrearEmpleado vistaCrearEmpleado;
	private VistaModificarEmpleado vistaModificarEmpleado;
	private VistaCrearSede vistaCrearSede;
	private VistaModSede vistaModSede;
	private VistaCrearVehiculo vistaCrearVehiculo;
	private VistaModVehiculo vistaModVehiculo;
	private VistaMenuAdmi vistaMenuAdmi;
	private VistaCrearSeguro vistaCrearSeguro;
	private VistaModSeguro vistaModSeguro;
	
	private Empresa empresa;
	
	private Escritura escritura;
	private Carga carga;
	private Comparador comparador;
	
	private Seguridad seguridad;
	
	
	public InterfazEmpresa(){
		
		empresa = new Empresa();

		escritura = new Escritura();
		carga = new Carga(this);
		comparador = new Comparador(this);

		seguridad = new Seguridad(this);

		carga.cargarDatos();
		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			
			try {
				escritura.escribirClientes(empresa.getClientes());
				escritura.escribirSedes(empresa.getSedes());
				escritura.escribirAdministradores(empresa.getSedes(), empresa.getAdministrador());
				escritura.escribirCategorias(empresa.getCategorias());
				escritura.escribirVehiculos(empresa.getVehiculos());
				escritura.escribirEmpleados(empresa.getSedes());
				escritura.escribirSeguros(empresa.getSeguros());
				escritura.escribirReservas(empresa.getClientes());
				escritura.escribirAlquileres(empresa.getClientes());
				escritura.escribirEstados(empresa.getVehiculos());
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.exit(0);
		}
		});

		vistaMenuInicial = new VistaMenuInicial(this);
		vistaInicioSesion = new VistaInicioSesion(this);
		vistaInicioSesionCliente = new VistaInicioSesionCliente(this);
		vistaMenuEmpleado = new VistaMenuEmpleado(this);
		vistaNuevaCuenta = new VistaNuevaCuenta(this);
		vistaMenuCliente = new VistaMenuCliente(this);
		vistaNuevaReserva = new VistaNuevaReserva(this);
		vistaHistorial = new VistaHistorial(this);
		vistaDispo = new VistaDispo(this);
		vistaRealizarPago = new VistaRealizarPago(this);
		vistaAdmiLocal = new VistaAdmiLocal(this);
		vistaCrearCategoria = new VistaCrearCategoria(this);
		vistaModCategoria = new VistaModCategoria(this);
		vistaAdmiLocal = new VistaAdmiLocal(this) ;
		vistaCrearCategoria = new VistaCrearCategoria(this) ;
		vistaModCategoria = new VistaModCategoria(this) ;
		vistaCrearEmpleado = new VistaCrearEmpleado(this) ;
		vistaModificarEmpleado = new VistaModificarEmpleado(this) ;
		vistaCrearSede = new VistaCrearSede(this) ;
		vistaModSede = new VistaModSede(this) ;
		vistaCrearVehiculo = new VistaCrearVehiculo(this) ;
		vistaModVehiculo = new VistaModVehiculo(this) ;
		vistaMenuAdmi = new VistaMenuAdmi(this) ;
		
		contenPanel = new JPanel();
		contenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenPanel);
		contenPanel.setLayout(new CardLayout(0,0));
		setResizable(false);
				
		setSize(1000, 700);
				
		setTitle("Empresa Vehiculos");
				
		setVisible(true);
		
		setLocationRelativeTo(null); 

		MenuInicial();
		empresa.setUsuarioActual(getEmpresa().getAdministrador());
	}
	
	/// Vistas
	
	public void nuevoPanel(JPanel vistaNueva) {
		contenPanel.removeAll();
		contenPanel.add(vistaNueva);
		contenPanel.repaint();
		contenPanel.revalidate();
	}

	public void MenuInicial(){
		nuevoPanel(vistaMenuInicial);
	}
	
	public void InicioCliente() {
		nuevoPanel((JPanel) vistaInicioSesionCliente.getContentPane());
	}
	
	public void InicioEmpleado() {
		nuevoPanel((JPanel) vistaInicioSesion.getContentPane());
	}
	
	public void nuevaCuenta() {
		nuevoPanel(vistaNuevaCuenta);
	}
	
	public void menuEmpleado() {
		nuevoPanel(vistaMenuEmpleado);
	}
	
	public void menuCliente() {
		nuevoPanel(vistaMenuCliente);
	}
	
	public void vistaNuevaReserva() {
		nuevoPanel(vistaNuevaReserva);
		
	}
	
	public void vistaHistorial() {
		nuevoPanel(vistaHistorial);
	}
	
	public void vistaDispo() {
		nuevoPanel(vistaDispo);
	}
	
	public void vistaPago() {
		nuevoPanel(vistaRealizarPago);
	}
	
	public void crearVehiclo() {
		nuevoPanel(vistaCrearVehiculo);
	}
	
	public void modVehiclo() {
		nuevoPanel(vistaModVehiculo);
	}
	
	public void crearEmpleado() {
		nuevoPanel(vistaCrearEmpleado);
	}
	
	public void modEmpleado() {
		nuevoPanel(vistaModificarEmpleado);
	}
	
	public void crearSeguro() {
		nuevoPanel(vistaCrearSeguro);
	}
	
	public void modSeguro() {
		nuevoPanel(vistaModSeguro);
	}
	
	public void menuAdmi() {
		nuevoPanel(vistaMenuAdmi);
	}
	
	public void crearSede() {
		nuevoPanel(vistaCrearSede);
	}
	
	public void modSede() {
		nuevoPanel(vistaModSede);
	}
	public void menuAdmiLocal() {
		nuevoPanel(vistaAdmiLocal);
	}
	
	public void crearCategoria() {
		nuevoPanel(vistaCrearCategoria);
	}
	
	public void modCategoria() {
		nuevoPanel(vistaModCategoria);
	}
	
	
	// Control
	
	public boolean ValidarCliente(String login, String password) {
		boolean k = seguridad.validarCredencialesCliente(login, password);
		return k;
	}

	public boolean ValidarEmpleado(String login, String password) {
		boolean k = seguridad.validarCredenciales(login, password);
		return k;
	}

	public boolean ValidarAdmin(String login, String password) {
		boolean k = seguridad.validarCredencialesAdmin(login, password);
		return k;
	}

	public boolean ValidarAdminLocal(String login, String password) {
		boolean k = seguridad.validarCredencialesAdminLocal(login, password);
		return k;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Comparador getComparador() {
		return comparador;
	}

	public static void main(String[] args) {
		InterfazEmpresa IE = new InterfazEmpresa();
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}


