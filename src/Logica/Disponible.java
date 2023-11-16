package Logica;

import java.sql.Date;

public class Disponible extends Estado{

	public Disponible(Sede sede, java.util.Date fecha, String descripcion, Empleado reportador) {
		super(sede, fecha, descripcion, reportador);
	}
}