package Logica;

import java.sql.Date;

public class Limpieza extends Estado{

	
	public Limpieza(Sede sede, String descripcion, Empleado limpiador, java.util.Date fecha) {
		super(sede, fecha, descripcion, limpiador);
	}
	
}
