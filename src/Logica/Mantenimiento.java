package Logica;

import java.sql.Date;

public class Mantenimiento extends Estado {

	private String taller;
	
	public Mantenimiento(Sede sede, java.util.Date fecha,String taller, String descripcion, Empleado reportador) {
		super(sede, fecha, descripcion, reportador);
		this.taller = taller;
	}

	public String getTaller() {
		return taller;
	}

	public void setTaller(String taller) {
		this.taller = taller;
	}
	
}
