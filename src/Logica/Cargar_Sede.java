package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

abstract class Cargar_Sede {
    public void cargarDatos(String nombre, String ubicacion, String horarios) {
        String directoryName = "data";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String csvFile = directoryName + File.separator + "sedes.csv";
        try {
            FileWriter writer = new FileWriter(csvFile, true);
            writer.append(nombre);
            writer.append(",");
            writer.append(ubicacion);
            writer.append(",");
            writer.append(horarios);
            writer.append("\n");

            writer.flush();
            writer.close();
            System.out.println("Se agregaron los datos de la sede al archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
