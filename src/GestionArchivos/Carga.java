package GestionArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import Interfaz.InterfazEmpresa;
import Logica.Categoria;
import Logica.Cliente;
import Logica.DatosContacto;
import Logica.DatosLicencia;
import Logica.DatosPago;
import Logica.Disponible;
import Logica.Estado;
import Logica.Limpieza;
import Logica.Mantenimiento;
import Logica.Rol;
import Logica.Sede;

public class Carga {

	private InterfazEmpresa intEmpresa; 
	private Comparador comparador;
	
	public Carga(InterfazEmpresa interfazEmpresa) {
		super();
		intEmpresa = interfazEmpresa;
		comparador = new Comparador(interfazEmpresa);
		
	}
	
	public void cargarDatos() {
		cargarClientes();
		cargarAdministrador();
		cargarSedes();
		cargarAdminsLocales();
		cargarCategorias();
		cargarVehiculos();
		cargarEmpleados();
		cargarSeguros();
		cargarReservas();
		cargarAlquileres();
		cargarEstados();
	}

	private void cargarClientes()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Clientes.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					int diaNacimiento = Integer.parseInt(partes[3]);
					int mesNacimiento = Integer.parseInt(partes[4]);
					int anoNacimiento = Integer.parseInt(partes[5]);
					String nacionalidad = partes[6];
					String direccion = partes[7];
					String email = partes[8];
					String telefono = partes[9];
					String licenciaNumero = partes[10];
					String licenciaPais = partes[11];
					int licenciaDia = Integer.parseInt(partes[12]);
					int licenciaMes = Integer.parseInt(partes[13]);
					int licenciaAno = Integer.parseInt(partes[14]);
					String pagoNumero = partes[15];
					String pagoCVV = partes[16];
					String pagoExpiracion = partes[17];
					
					DatosContacto datosContacto = new DatosContacto(telefono, direccion, email);
					DatosLicencia datosLicencia = new DatosLicencia(licenciaNumero, licenciaPais, new Date(licenciaAno, licenciaMes, licenciaDia));
					DatosPago datosPago = new DatosPago(pagoNumero, pagoExpiracion, pagoCVV);
					
					intEmpresa.getEmpresa().nuevoCliente(usuario, contraseña, nombre,new Date(anoNacimiento, mesNacimiento, diaNacimiento) , nacionalidad, null, datosContacto, datosLicencia, datosPago);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}
	
	private void cargarSedes()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Sedes.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String nombre = partes[0];
					String direccion = partes[1];
					String horarios = partes[2];
					
					
					intEmpresa.getEmpresa().getAdministrador().crearSede(nombre, direccion, horarios, null);;

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}

	private void cargarAdministrador()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Administradores.csv")));
				String linea = br.readLine();
				
				String[] partes = linea.split(";");
				String usuario = partes[0];
				String contraseña = partes[1];
				String nombre = partes[2];
					
				intEmpresa.getEmpresa().setAdministrador(usuario, contraseña, nombre);

				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	private void cargarAdminsLocales()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Administradores.csv")));
				String linea = br.readLine();
				linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String sede = partes[3];
					
					
					int k = comparador.compararSede(sede);
					
					intEmpresa.getEmpresa().getAdministrador().asignarAdminLocal(usuario, contraseña, nombre, intEmpresa.getEmpresa().getSedes().get(k));
					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	private void cargarCategorias()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Categorias.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String nombre = partes[0];
					String gamma = partes[1];
					double tarifaAlta = Double.parseDouble(partes[2]);
					double tarifaBaja = Double.parseDouble(partes[3]);
					double extraSede = Double.parseDouble(partes[4]);
					double extraConductor = Double.parseDouble(partes[5]);
					
					intEmpresa.getEmpresa().getAdministrador().crearCategoria(nombre, gamma, tarifaAlta, tarifaBaja, extraSede, extraConductor);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}

	private void cargarVehiculos()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Vehiculos.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					
					String[] partes = linea.split(";");
					String placa = partes[0];
					String marca = partes[1];
					String modelo = partes[2];
					String color = partes[3];
					int capacidad = Integer.parseInt(partes[4]);
					String tipoTransmision = partes[5];
					String categoria = partes[6];
 
					int iCat = 1000000000 ;
					boolean encontroCategoria = true;
					for (int i=0 ; (i<intEmpresa.getEmpresa().getCategorias().size())&&encontroCategoria; i++ ) {
						if (categoria.equals(intEmpresa.getEmpresa().getCategorias().get(i).getNombre())) {
							iCat = i;
							encontroCategoria = false;
						}
					}
					
					intEmpresa.getEmpresa().getAdministrador().crearVehiculo(placa, marca, modelo, color, tipoTransmision, capacidad, intEmpresa.getEmpresa().getCategorias().get(iCat));

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}

	private void cargarEmpleados()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Empleados.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String rol = partes[3];
					String sede = partes[4];
					
					int k=comparador.compararSede(sede);
					
					intEmpresa.getEmpresa().getSedes().get(k).getAdmin().crearEmpleado(usuario, contraseña, nombre, comparador.compararRol(rol), intEmpresa.getEmpresa().getSedes().get(k));

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}
	
	private void cargarSeguros()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Seguros.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String nombre = partes[0];
					double costoDiario = Double.parseDouble(partes[1]);
					
					intEmpresa.getEmpresa().getAdministrador().crearSeguro(nombre, costoDiario);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	private void cargarReservas()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Reservas.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String categoria = partes[1];
					double tarifa = Double.parseDouble(partes[2]);
					String sedeRecogida = partes[3];
					int diaRecogida = Integer.parseInt(partes[4]);
					int mesRecogida = Integer.parseInt(partes[5]);
					int anoRecogida = Integer.parseInt(partes[6]);
					int horaRecogida = Integer.parseInt(partes[7]);
					String sedeEntrega = partes[8];
					int diaEntrega = Integer.parseInt(partes[9]);
					int mesEntrega = Integer.parseInt(partes[10]);
					int anoEntrega = Integer.parseInt(partes[11]);
					int horaEntrega = Integer.parseInt(partes[12]);
					
					int iCliente = comparador.compararCliente(usuario);
					
					int iCategoria = comparador.compararCategoria(categoria);
					
					int iSedeRec = comparador.compararSede(sedeRecogida);
					
					int iSedeEnt = comparador.compararSede(sedeEntrega);
					
					intEmpresa.getEmpresa().getClientes().get(iCliente).crearReserva(new java.util.Date(anoRecogida, mesRecogida, diaRecogida, horaRecogida, 0), new java.util.Date(anoEntrega, mesEntrega, diaEntrega, horaEntrega, 0), tarifa, intEmpresa.getEmpresa().getCategorias().get(iCategoria), intEmpresa.getEmpresa().getSedes().get(iSedeRec), intEmpresa.getEmpresa().getSedes().get(iSedeEnt));

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	private void cargarAlquileres()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Alquileres.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String sedeRecogida = partes[1];
					int diaRecogida = Integer.parseInt(partes[2]);
					int mesRecogida = Integer.parseInt(partes[3]);
					int anoRecogida = Integer.parseInt(partes[4]);
					int horaRecogida = Integer.parseInt(partes[5]);
					String sedeEntrega = partes[6];
					int diaEntrega = Integer.parseInt(partes[7]);
					int mesEntrega = Integer.parseInt(partes[8]);
					int anoEntrega = Integer.parseInt(partes[9]);
					int horaEntrega = Integer.parseInt(partes[10]);
					String vehiculo = partes[11];
					String seguro = partes[12];
					
					int iCliente = comparador.compararCliente(usuario);
					
					int iSedeRec = comparador.compararSede(sedeRecogida);
					
					int iSedeEnt = comparador.compararSede(sedeEntrega);
					
					int iVehiculo = comparador.compararVehiculo(vehiculo);
					
					int iSeguro = comparador.compararSeguros(seguro);
					
					intEmpresa.getEmpresa().getAdministrador().crearAlquiler(intEmpresa.getEmpresa().getClientes().get(iCliente), intEmpresa.getEmpresa().getSedes().get(iSedeRec), new java.util.Date(anoEntrega, mesEntrega, diaEntrega, horaEntrega, 0), intEmpresa.getEmpresa().getSedes().get(iSedeEnt), intEmpresa.getEmpresa().getVehiculos().get(iVehiculo), intEmpresa.getEmpresa().getSeguros().get(iSeguro), null, new java.util.Date(anoRecogida, mesRecogida, diaRecogida, horaRecogida, 0));

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	private void cargarEstados()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Estados.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String vehiculo = partes[0];
					String estado = partes[1];
					String sede = partes[2];
					int dia = Integer.parseInt(partes[3]);
					int mes = Integer.parseInt(partes[4]);
					int ano = Integer.parseInt(partes[5]);
					int hora = Integer.parseInt(partes[6]);
					String descripcion = partes[7];
					String empleado = partes[8];
					
					int iVehiculo = comparador.compararVehiculo(vehiculo);
					
					int iSede = comparador.compararSede(sede);
					
					int iEmpleado = comparador.compararEmpleado(empleado);
					
					
					
					if (estado.equals("Disponible")) {
						intEmpresa.getEmpresa().getVehiculos().get(iVehiculo).setEstadoActual(new Disponible(intEmpresa.getEmpresa().getSedes().get(iSede), new java.util.Date(ano, mes, dia, hora, 0), descripcion,intEmpresa.getEmpresa().getSedes().get(iSede).getEmpleados().get(iEmpleado)));
					}
					else if (estado.equals("Limpieza")) {
						intEmpresa.getEmpresa().getVehiculos().get(iVehiculo).setEstadoActual(new Limpieza(intEmpresa.getEmpresa().getSedes().get(iSede), descripcion, intEmpresa.getEmpresa().getSedes().get(iSede).getEmpleados().get(iEmpleado), new java.util.Date(ano, mes, dia, hora, 0)));
					}
					else if (estado.equals("Mantenimiento")) {
						intEmpresa.getEmpresa().getVehiculos().get(iVehiculo).setEstadoActual(new Mantenimiento(intEmpresa.getEmpresa().getSedes().get(iSede), new java.util.Date(ano, mes, dia, hora, 0), empleado, descripcion, intEmpresa.getEmpresa().getSedes().get(iSede).getEmpleados().get(iEmpleado)));
					}
//					else if (estado.equals("Alquiler")) {
//						int[] iCli = comparador.compararAlquiler(vehiculo, dia, mes, ano);
//						intEmpresa.getEmpresa().getVehiculos().get(iVehiculo).setEstadoActual(intEmpresa.getEmpresa().getClientes().get(iCli[0]).getAlquileres().get(iCli[1]));
//					}
					
					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
}
