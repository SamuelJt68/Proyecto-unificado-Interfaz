
package Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.DatosContacto;
import Logica.DatosLicencia;
import Logica.DatosPago;

class BotonRedondeado extends JButton {

    public BotonRedondeado(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);
        setBackground(new Color(250, 0, 0));
        setForeground(Color.white);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 18));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(180, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(220, 0, 0));
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }
}

public class VistaNuevaCuenta extends JPanel implements ActionListener {

    private JLabel labelPeticion;
    private JLabel labelUsuario;
    private JLabel labelContrasena;
    private JLabel labelNombre;
    private JLabel labelApellido;
    private JLabel labelFechaNacimiento;
    private JLabel labelNacionalidad;
    private JLabel labelImagenID;
    private JLabel labelDatosLicencia;
    private JLabel labelNumero;
    private JLabel labelPaisExpedicion;
    private JLabel labelFechaVencimiento;
    private JLabel labelImagen;
    private JLabel labelDatosContacto;
    private JLabel labelTelefono;
    private JLabel labelDireccion;
    private JLabel labelEmail;
    private JLabel labelDatosPago;
    private JLabel labelNumeroTarjeta;
    private JLabel labelExpiracion;
    private JLabel labelCVV;

    private JTextField tUsuario;
    private JTextField tContrasena;
    private JTextField tNombre;
    private JTextField tApellido;
    private JTextField tFechaNacimiento;
    private JTextField tNacionalidad;
    private JTextField tImagenID;
    private JTextField tNumero;
    private JTextField tPaisExpedicion;
    private JTextField tFechaVencimiento;
    private JTextField tImagen;
    private JTextField tTelefono;
    private JTextField tDireccion;
    private JTextField tEmail;
    private JTextField tNumeroTarjeta;
    private JTextField tExpiracion;
    private JTextField tCVV;

    private BotonRedondeado confirmar;
    private BotonRedondeado ImagenID;
    private BotonRedondeado Imagen;

    private InterfazEmpresa interfaz;
    private JFileChooser fileChooser;

    public VistaNuevaCuenta(InterfazEmpresa interfaz) {

        this.interfaz = interfaz;

        TitledBorder border = new TitledBorder("Crear nuevo usuario");
        setBorder(border);
        setPreferredSize(new Dimension(1000, 700));
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen (.jpg)", "jpg");
        fileChooser.setFileFilter(filter);

        initUI();
    }

    private void initUI() {
        setLayout(new FlowLayout());

        labelPeticion = createLabel("Ingrese los siguientes datos:");
        labelUsuario = createLabel("Usuario:");
        labelContrasena = createLabel("Contraseña:");
        labelNombre = createLabel("Nombre:");
        labelApellido = createLabel("Apellido:");
        labelFechaNacimiento = createLabel("Fecha de nacimiento:");
        labelNacionalidad = createLabel("Nacionalidad:");
        labelImagenID = createLabel("Imagen ID:");
        labelDatosLicencia = createLabel("Datos Licencia");
        labelNumero = createLabel("Numero de licencia:");
        labelPaisExpedicion = createLabel("Pais de expedicion:");
        labelFechaVencimiento = createLabel("Fecha de vencimiento:");
        labelImagen = createLabel("Foto de licencia:");
        labelDatosContacto = createLabel("Datos Contacto");
        labelTelefono = createLabel("Telefono:");
        labelDireccion = createLabel("Direccion:");
        labelEmail = createLabel("Email:");
        labelDatosPago = createLabel("Datos Pago");
        labelNumeroTarjeta = createLabel("Numero Tarjeta:");
        labelExpiracion = createLabel("Expiracion:");
        labelCVV = createLabel("CVV:");

        tUsuario = createTextField();
        tContrasena = createTextField();
        tNombre = createTextField();
        tApellido = createTextField();
        tFechaNacimiento = createTextField();
        tNacionalidad = createTextField();
        tImagenID = createTextField();
        tNumero = createTextField();
        tPaisExpedicion = createTextField();
        tFechaVencimiento = createTextField();
        tImagen = createTextField();
        tTelefono = createTextField();
        tDireccion = createTextField();
        tEmail = createTextField();
        tNumeroTarjeta = createTextField();
        tExpiracion = createTextField();
        tCVV = createTextField();

        confirmar = new BotonRedondeado("Confirmar");
        confirmar.addActionListener(this);

        ImagenID = new BotonRedondeado("Imagen ID");
        ImagenID.addActionListener(this);

        Imagen = new BotonRedondeado("Imagen");
        Imagen.addActionListener(this);

        add(labelPeticion);
        add(labelUsuario);
        add(tUsuario);
        add(labelContrasena);
        add(tContrasena);
        add(labelNombre);
        add(tNombre);
        add(labelApellido);
        add(tApellido);
        add(labelFechaNacimiento);
        add(tFechaNacimiento);
        add(labelNacionalidad);
        add(tNacionalidad);
        add(labelImagenID);
        add(ImagenID);
        add(labelDatosLicencia);
        add(labelNumero);
        add(tNumero);
        add(labelPaisExpedicion);
        add(tPaisExpedicion);
        add(labelFechaVencimiento);
        add(tFechaVencimiento);
        add(labelImagen);
        add(Imagen);
        add(labelDatosContacto);
        add(labelTelefono);
        add(tTelefono);
        add(labelDireccion);
        add(tDireccion);
        add(labelEmail);
        add(tEmail);
        add(labelDatosPago);
        add(labelNumeroTarjeta);
        add(tNumeroTarjeta);
        add(labelExpiracion);
        add(tExpiracion);
        add(labelCVV);
        add(tCVV);
        add(confirmar);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        
		String usuario = tUsuario.getText();
		String contrasena = tContrasena.getText();
		String nombre = tNombre.getText();
		String apellido = tApellido.getText();
		String fechaNacimiento = tFechaNacimiento.getText();
		String nacionalidad = tNacionalidad.getText();
		String numero = tNumero.getText();
		String paisExpedicion = tPaisExpedicion.getText();
		String fechaVencimiento = tFechaVencimiento.getText();
		String telefono = tTelefono.getText();
		String direccion = tDireccion.getText();
		String email = tEmail.getText();
		String numeroTarjeta = tNumeroTarjeta.getText();
		String expiracion = tExpiracion.getText();
		String CVV = tCVV.getText();

        if (command.equals("Confirmar")) {
            DatosContacto datosC = new DatosContacto(telefono, direccion, email);
            DatosLicencia datosL = new DatosLicencia(numeroTarjeta, paisExpedicion,new Date(2023, 8, 23));
            DatosPago datosP = new DatosPago(numeroTarjeta, expiracion, CVV);

            interfaz.getEmpresa().nuevoCliente(usuario, contrasena, nombre +" "+ apellido, new Date(2002, 6, 18), nacionalidad, null, datosC, datosL, datosP);
            interfaz.InicioCliente();
        } else if (command.equals("Imagen ID")) {
        
        	int result = fileChooser.showOpenDialog(VistaNuevaCuenta.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
            	
            }
            
        } else if (command.equals("Imagen")) {
        	int result = fileChooser.showOpenDialog(VistaNuevaCuenta.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
            	
            }
        }
    }
}

