package Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class BotonRedondeado extends JButton{

	public BotonRedondeado(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);
        setBackground(new Color(255, 0, 0)); 
        setForeground(Color.white);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 18));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(150, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(220, 0, 0)); 
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

	
}

public class VistaInicioSesionCliente extends JFrame implements ActionListener {
	
	private JLabel labelUsuario;
	private JLabel labelContrasena;
	private JLabel labelNuevaCuenta;
	private JLabel labelTitulo;
	
	private JTextField textUsuario;
	private JTextField textContrasena;
	
	private BotonRedondeado nuevaCuenta;
	private BotonRedondeado confirmar;
    private BotonRedondeado volver;

	
	private  InterfazEmpresa interfaz;

	    private JPanel contenidoPanel;

	    public VistaInicioSesionCliente(InterfazEmpresa interfaz){
	    	
	    	
	    	
	    	this.interfaz = interfaz;
	    	
	        setTitle("Iniciar Sesión");
	        setSize(1000, 700);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        
	        contenidoPanel = new JPanel();
	        contenidoPanel.setLayout(new GridLayout(7, 1, 10, 10));
	        labelTitulo = new JLabel("Iniciar Sesión");
	        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
	        labelTitulo.setHorizontalAlignment(JLabel.CENTER);

	        labelUsuario = new JLabel("Usuario:");
	        textUsuario = new JTextField();

	        labelContrasena = new JLabel("Contraseña:");
	        textContrasena = new JPasswordField();

	        confirmar = new BotonRedondeado("Iniciar Sesión");
	        confirmar.setActionCommand("Iniciar sesion");
	        confirmar.addActionListener(this);
	        
	        volver = new BotonRedondeado("Volver");
	        volver.setActionCommand("Volver");
	        volver.addActionListener(this); 
	        
	        nuevaCuenta = new BotonRedondeado("Crear nuevo usuario");
	        nuevaCuenta.setActionCommand("Crear nuevo usuario");
	        nuevaCuenta.addActionListener(this);
	        
	        

	        
	        contenidoPanel.add(labelTitulo);
	        contenidoPanel.add(new JLabel()); 
	        contenidoPanel.add(labelUsuario);
	        contenidoPanel.add(textUsuario);
	        contenidoPanel.add(labelContrasena);
	        contenidoPanel.add(textContrasena);
	        contenidoPanel.add(confirmar);
	        contenidoPanel.add(volver);
	        contenidoPanel.add(nuevaCuenta);
	        
	        contenidoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	        
	        
	        TitledBorder border = new TitledBorder("Inicio Sesión");
	        contenidoPanel.setBorder(border);
	        
	        add(contenidoPanel);
	       
	    }

	    @Override
		public void actionPerformed(ActionEvent e) {
			
			String grito = e.getActionCommand();
			String usuario = textUsuario.getText();
			String contrasena = textContrasena.getText();
			
			if (grito.equals("Iniciar sesion")) {
				boolean cUsuarioReg = interfaz.ValidarCliente(usuario,contrasena);
				if (cUsuarioReg == true) {
					interfaz.menuCliente();
				}
				else {
					JOptionPane.showMessageDialog(this,"El usuario o contraseña son incorrectos", "Usuario no encontrado", JOptionPane.INFORMATION_MESSAGE );
				}
			}
			else if (grito.equals("Crear nuevo usuario")) {
					interfaz.nuevaCuenta();
			}
			else if(grito.equals("Volver")) {
				interfaz.MenuInicial();
				}
			}
			
}
