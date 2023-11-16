package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class VistaMenuCliente extends JPanel implements ActionListener {

	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelUsuario;
	private JLabel labelRealizarReserva;
	private JLabel labelModificarReserva;
	private JLabel labelHistorial;
	
	private JButton RealizarReserva;
	private JButton ModificarReserva;
	private JButton Historial;
	
	private InterfazEmpresa interfaz;
	
	public VistaMenuCliente(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Menú usuario");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		
		JPanel panel = new JPanel(new BorderLayout());

        JPanel fondoRojoPanel = new JPanel(new GridLayout(4, 1));
        fondoRojoPanel.setBackground(new Color(255, 0, 0));
        fondoRojoPanel.setPreferredSize(new Dimension(1000 * 40 / 100, 700));

        String[] etiquetas = {"Bienvenido", "Nombre", "Numero de licencia", "Telefono"};

        for (String etiqueta : etiquetas) {
            JLabel label = new JLabel(etiqueta);
            label.setForeground(Color.white);
            label.setHorizontalAlignment(JLabel.CENTER);
            if (etiqueta.equals("Bienvenido")) {
                label.setFont(new Font("Arial", Font.BOLD, 24)); 
                label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            }
            else {
                label.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0)); 
            }
            
            fondoRojoPanel.add(label);
        }

        JPanel botonesPanel = new JPanel(new GridLayout(3, 1));
        botonesPanel.setPreferredSize(new Dimension(1000 * 60 / 100, 700));

        BotonRedondeado nuevaReservaButton = new BotonRedondeado("Nueva reserva");
		nuevaReservaButton.setActionCommand("Reserva");
		nuevaReservaButton.addActionListener(this);
        BotonRedondeado historialButton = new BotonRedondeado("Historial");
        historialButton.setActionCommand("Historial");
        historialButton.addActionListener(this);
        
        botonesPanel.add(new JPanel());


        JPanel botonesDerechosPanel = new JPanel(new GridLayout(2, 1));
        botonesDerechosPanel.add(nuevaReservaButton);
        botonesDerechosPanel.add(historialButton);
        botonesDerechosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        botonesPanel.add(botonesDerechosPanel);
       
        
        panel.add(fondoRojoPanel, BorderLayout.WEST);
        panel.add(botonesPanel, BorderLayout.CENTER);

        BotonRedondeado cerrarSesionButton = new BotonRedondeado("Cerrar sesión");
        cerrarSesionButton.setPreferredSize(new Dimension(150, 40));
        cerrarSesionButton.setHorizontalAlignment(SwingConstants.RIGHT);
        cerrarSesionButton.setActionCommand("Cerrar sesion");
		cerrarSesionButton.addActionListener(this);
        
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.add(cerrarSesionButton);
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        panel.add(panelInferior, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Reserva")) {
			interfaz.vistaNuevaReserva();
		}
		else if (action.equals("Historial")) {
			interfaz.vistaHistorial();
		}
		else if (action.equals("Cerrar sesion")) {
			interfaz.MenuInicial();
		}
	}

}
