package Logica;
import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;

public class Sede {
	
	private String nombre;
	private String direccion;
	private String horarios;
	private AdminLocal admin;
	private ArrayList<Empleado> empleados;
	private ArrayList<Reserva> reservasPendientes;
	
	public Sede(String nombre, String direccion, String horarios, AdminLocal admin) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.admin = admin;
		empleados = new ArrayList<Empleado>();
		reservasPendientes = new ArrayList<Reserva>();
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public AdminLocal getAdmin() {
		return admin;
	}

	public void setAdmin(AdminLocal admin) {
		this.admin = admin;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void añadirEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public ArrayList<Reserva> getReservasPendientes() {
		return reservasPendientes;
	}
	
	public void agregarReservaPendiente(Reserva reserva) {
		reservasPendientes.add(reserva);
	}
	
	public void eliminarReservaPendiente(Reserva reserva) {
		reservasPendientes.remove(reservasPendientes.indexOf(reserva));
	}
	
	
//	public void transferirVehiculo(String placa, String sedeDestino) {
//        String directoryName = "data";
//        File directory = new File(directoryName);
//        if (!directory.exists()) {
//            directory.mkdir();
//        }
//        try {
//            File inputFile = new File(directoryName + File.separator + "vehiculos.csv");
//            File tempFile = new File(directoryName + File.separator + "temp_vehiculos.csv");
//
//            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length >= 9 && data[0].equals(placa)) {
//                    line = placa + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + sedeDestino;
//                }
//                writer.write(line + System.getProperty("line.separator"));
//            }
//            reader.close();
//            writer.close();
//
//            if (!inputFile.delete()) {
//                System.out.println("No se pudo eliminar el archivo original.");
//                return;
//            }
//            if (!tempFile.renameTo(inputFile)) {
//                System.out.println("No se pudo renombrar el archivo temporal.");
//            }
//
//            System.out.println("El vehículo con la placa " + placa + " se ha transferido a la sede " + sedeDestino);
//        } catch (IOException e) {
//            System.out.println("Error al realizar la transferencia del vehículo: " + e.getMessage());
//        }
//    }
//	
//	public void gestionarInventario(String placa, String estado) {
//        String directoryName = "data";
//        File directory = new File(directoryName);
//        if (!directory.exists()) {
//            directory.mkdir();
//        }
//        try {
//            File inputFile = new File(directoryName + File.separator + "vehiculos.csv");
//            File tempFile = new File(directoryName + File.separator + "temp_vehiculos.csv");
//
//            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length >= 9 && data[0].equals(placa)) {
//                    line = placa + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + estado + "," + data[8];
//                }
//                writer.write(line + System.getProperty("line.separator"));
//            }
//            reader.close();
//            writer.close();
//
//            if (!inputFile.delete()) {
//                System.out.println("No se pudo eliminar el archivo original.");
//                return;
//            }
//            if (!tempFile.renameTo(inputFile)) {
//                System.out.println("No se pudo renombrar el archivo temporal.");
//            }
//
//            System.out.println("El estado del vehículo con la placa " + placa + " se ha actualizado a " + estado);
//        } catch (IOException e) {
//            System.out.println("Error al gestionar el inventario del vehículo: " + e.getMessage());
//        }
//    }
	
}
