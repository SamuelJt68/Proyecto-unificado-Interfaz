package GestionArchivos;

import Interfaz.InterfazEmpresa;
import Logica.Rol;
import Logica.Vehiculo;

public class Comparador {

	private InterfazEmpresa intEmpresa; 
	
	public Comparador(InterfazEmpresa interfazEmpresa) {
		super();
		intEmpresa = interfazEmpresa;
	}
	
	public int compararCliente(String usuario) {
		int iCliente = -1;
		boolean encontroCliente = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getClientes().size())&&encontroCliente; i++ ) {
			if (usuario.equals(intEmpresa.getEmpresa().getClientes().get(i).getUsuario())) {
				iCliente=i;
				encontroCliente = false;
			}
		}
		return iCliente;
	}
	
	public int compararSede(String sede) {
		int iSede = -1;
		boolean encontroSede = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&encontroSede; i++ ) {
			if (sede.equals(intEmpresa.getEmpresa().getSedes().get(i).getNombre())) {
				iSede =i;
				encontroSede = false;
			}
		}
		return iSede;
	}
	
	public int compararCategoria(String categoria) {
		int iCat = -1 ;
		boolean encontroCategoria = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getCategorias().size())&&encontroCategoria; i++ ) {
			if (categoria.equals(intEmpresa.getEmpresa().getCategorias().get(i).getNombre())) {
				iCat = i;
				encontroCategoria = false;
			}
		}
		return iCat;
	}
	
	public int compararVehiculo(String vehiculo) {
		int iVeh = -1 ;
		boolean encontroVehiculo = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getVehiculos().size())&&encontroVehiculo; i++ ) {
			if (vehiculo.equals(intEmpresa.getEmpresa().getVehiculos().get(i).getPlaca())) {
				iVeh = i;
				encontroVehiculo = false;
			}
		}
		return iVeh;
	}
	
	public int compararSeguros(String seguro) {
		int iSeg = -1 ;
		boolean encontroSeguro = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getSeguros().size())&&encontroSeguro; i++ ) {
			if (seguro.equals(intEmpresa.getEmpresa().getSeguros().get(i).getNombre())) {
				iSeg = i;
				encontroSeguro = false;
			}
		}
		return iSeg;
	}
	
	public int compararEmpleado(String empleado) {
		int iEmpl = -1 ;
		boolean encontroEmpleado = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&encontroEmpleado; i++ ) {
			for (int j=0 ; (j<intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().size())&&encontroEmpleado; j++ ) {
				if (empleado.equals(intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().get(j).getUsuario())) {
					iEmpl = i;
					encontroEmpleado = false;
				}
			}
		}
		return iEmpl;
	}
	
	public int[] compararAlquiler(String vehiculo,Integer date, Integer mes, Integer ano) {
		int iCli = -1 ;
		int iAlq = -1 ;
		boolean encontroAlquiler = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getClientes().size())&&encontroAlquiler; i++ ) {
			for (int j=0 ; (j<intEmpresa.getEmpresa().getClientes().get(i).getAlquileres().size())&&encontroAlquiler; j++ ) {
				if (((date.equals(intEmpresa.getEmpresa().getClientes().get(i).getAlquileres().get(j).getFecha().getDate()))&&(mes.equals(intEmpresa.getEmpresa().getClientes().get(i).getAlquileres().get(j).getFecha().getMonth())))&&(ano.equals(intEmpresa.getEmpresa().getClientes().get(i).getAlquileres().get(j).getFecha().getYear()))) {
					if(vehiculo.equals(intEmpresa.getEmpresa().getClientes().get(i).getAlquileres().get(j).getVehiculo().getPlaca())) {
						iCli = i;
						iAlq = j;
						encontroAlquiler = false;
					}
				}
			}
		}
		int[] cAlq = {iCli , iAlq};
		
		return cAlq;
	}
	
	public Rol compararRol(String rol) {
		Rol tRol = null;
		if (rol.equals("ATENCION")) {
			tRol = Rol .ATENCION;
		}
		if (rol.equals("LIMPEZA")) {
			tRol = Rol .LIMPEZA;
		}
		if (rol.equals("MANTENIMIENTO")) {
			tRol = Rol .MANTENIMIENTO;
		}
		return tRol;
	}
}
