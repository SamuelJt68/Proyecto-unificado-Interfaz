package Interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VistaCrearEmpleado extends JPanel implements ActionListener, MouseListener {
	
	
	private InterfazEmpresa interfaz;
	
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JComboBox<String> rol;
	
	
	
	public VistaCrearEmpleado(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Crear nuevo empleado");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		setLayout(null);
		addMouseListener(this);
		textApellido = new JTextField();
		textApellido.setBounds(400, 213, 500, 25);
		textNombre = new JTextField();
		textNombre.setBounds(400, 263, 500, 25);
		textUsuario = new JTextField();
		textUsuario.setBounds(400, 313, 500, 25);
		textContrasena = new JTextField();
		textContrasena.setBounds(400, 363, 500, 25);
		
		String[] opciones = {"Empleado","Administrador","Administrador local"};
        
        rol = new JComboBox<>(opciones);
        rol.setActionCommand("ROL");
        rol.addActionListener(this);
        
     
        rol.setBounds(400, 413, 500, 25);
		
		add(textApellido);
		add(textNombre);
		add(textUsuario);
		add(textContrasena);
		add(rol);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
			
		Graphics2D g2d = (Graphics2D) g;
		
		RoundRectangle2D.Double izq = new RoundRectangle2D.Double (2, 15, 200, 635, 5, 5);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(izq);
		
		RoundRectangle2D.Double ap = new RoundRectangle2D.Double (245, 210, 150, 30, 15, 15);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(ap);
		
		RoundRectangle2D.Double nom = new RoundRectangle2D.Double (245, 260, 150, 30, 15, 15);
		g2d.fill(nom);
		
		RoundRectangle2D.Double us = new RoundRectangle2D.Double (245, 310, 150, 30, 15, 15);
		g2d.fill(us);
		
		RoundRectangle2D.Double con = new RoundRectangle2D.Double (245, 360, 150, 30, 15, 15);
		g2d.fill(con);
		
		RoundRectangle2D.Double rol = new RoundRectangle2D.Double (245, 410, 150, 30, 15, 15);
		g2d.fill(rol);
		
		RoundRectangle2D.Double cancelar = new RoundRectangle2D.Double (760, 600, 100, 30, 15, 15);
		g2d.fill(cancelar);
		RoundRectangle2D.Double crear = new RoundRectangle2D.Double (870, 600, 75, 30, 15, 15);
		g2d.fill(crear);
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Ingresa los datos del nuevo empleado", 240,150);
		
		
		Font k =new Font("Microsoft YaHei", Font.BOLD, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Apellido", 250,233);
		
		g2d.drawString("Nombre", 250,283);
		
		g2d.drawString("Usuario", 250,333);
		
		g2d.drawString("Contraseña", 250,383);
		
		g2d.drawString("Rol", 250,433);
		Font m =new Font("Microsoft YaHei", Font.PLAIN, 20);
		g2d.setFont(m);
		g2d.setColor(Color.white);
		g2d.drawString("Crear", 880,623);
		g2d.drawString("Cancelar", 770,623);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		int clickEY = e.getY();
		int clickEX = e.getX();
	
		//volver a menu anterior 
		if ((600<clickEY)&&(clickEY<630) && (760<clickEX)&&(clickEX<860)){
			//falta modificar
			interfaz.InicioEmpleado();;

		}
		//guardar nueva info vehiculo
		else if ((600<clickEY)&&(clickEY<630) && (870<clickEX)&&(clickEX<945)){
			//falta agregar logica que guarde el empleado
			interfaz.menuAdmi();
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}