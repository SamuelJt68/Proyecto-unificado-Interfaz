package ControladorSesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.InterfazEmpresa;
import Logica.Cliente;
import Logica.Sede;

public class Seguridad {
	
	private InterfazEmpresa intEmpresa;
	
    public Seguridad(InterfazEmpresa intEmpresa) {
		super();
		this.intEmpresa = intEmpresa;
	}

	public boolean validarCredenciales(String login, String password) {
    	
		boolean credencial = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&credencial; i++ ) {
			for (int j=0 ; (j<intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().size())&&credencial; j++ ) {
				if ((password.equals(intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().get(j).getContraseña()))&&(login.equals(intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().get(j).getUsuario()))) {
					intEmpresa.getEmpresa().setUsuarioActual(intEmpresa.getEmpresa().getSedes().get(i).getEmpleados().get(j));
					credencial= false;
				}
			}
		}
		
        return !credencial;
    }

	public boolean validarCredencialesAdmin(String login, String password) {
    	
		boolean credencial = true;
			if ((password.equals(intEmpresa.getEmpresa().getAdministrador().getContraseña()))&&(login.equals(intEmpresa.getEmpresa().getAdministrador().getUsuario()))) {
				intEmpresa.getEmpresa().setUsuarioActual(intEmpresa.getEmpresa().getAdministrador());
				credencial= false;
			}
        return !credencial;
    }

	public boolean validarCredencialesAdminLocal(String login, String password) {
    	
		boolean credencial = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&credencial; i++ ) {
			if ((password.equals(intEmpresa.getEmpresa().getSedes().get(i).getAdmin().getContraseña()))&&(login.equals(intEmpresa.getEmpresa().getSedes().get(i).getAdmin().getUsuario()))) {
				intEmpresa.getEmpresa().setUsuarioActual(intEmpresa.getEmpresa().getSedes().get(i).getAdmin());
				credencial= false;
			}
		}
		
        return !credencial;
    }

    public boolean validarCredencialesCliente(String login, String password) {
    	boolean credencial = true;
		for (int i=0 ; (i<intEmpresa.getEmpresa().getClientes().size())&&credencial; i++ ) {
			if ((password.equals(intEmpresa.getEmpresa().getClientes().get(i).getContraseña()))&&(login.equals(intEmpresa.getEmpresa().getClientes().get(i).getUsuario()))) {
				intEmpresa.getEmpresa().setUsuarioActual(intEmpresa.getEmpresa().getClientes().get(i));
				credencial= false;
			}
		}
        return !credencial;
    }
}
