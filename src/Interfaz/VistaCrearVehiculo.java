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

public class VistaCrearVehiculo extends JPanel implements ActionListener, MouseListener {
	
	
	private InterfazEmpresa interfaz;
	
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textPlaca;
	private JComboBox<String> color;
	private JComboBox<String> capacidad;
	private JComboBox<String> transmision;
	private JComboBox<String> categoria;
	
	
	
	public VistaCrearVehiculo(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Registrar nuevo vehículo");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		setLayout(null);
		addMouseListener(this);
		
		textMarca = new JTextField();
		textMarca.setBounds(250, 243, 180, 25);
		textModelo = new JTextField();
		textModelo.setBounds(450, 243, 180, 25);
		textPlaca = new JTextField();
		textPlaca.setBounds(650, 243, 180, 25);
		add(textMarca);
		add(textModelo);
		add(textPlaca);
		
		
		String[] colores = {"Plateado","Negro","Blanco", "Rojo", "Azul", "Amarillo", "Verde", "Rosado", "Morado", "Dorado", "Gris", "Beige", "Naranja", "Marrón"};
		String[] puestos = {"1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
		String[] tipoTransmision = {"Manual","Automática"};
		String[] categorias = {"1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
		
        color = new JComboBox<>(colores);
        color.setActionCommand("COLOR");
        color.addActionListener(this);
        
        color.setBounds(250, 343, 180, 25);
        
        capacidad = new JComboBox<>(puestos);
        capacidad.setActionCommand("CAPACIDAD");
        capacidad.addActionListener(this);
        
        capacidad.setBounds(450, 343, 180, 25);
        
        transmision = new JComboBox<>(tipoTransmision);
        transmision.setActionCommand("TRANSMISION");
        transmision.addActionListener(this);
        
        transmision.setBounds(650, 343, 180, 25);
        
        categoria = new JComboBox<>(categorias);
        categoria.setActionCommand("CATEGORIA");
        categoria.addActionListener(this);
        
        categoria.setBounds(250, 443, 180, 25);
		
        add(color);
        add(capacidad);
        add(transmision);
        add(categoria);
        
		
	}
	public void paint(Graphics g) {
		super.paint(g);
			
		Graphics2D g2d = (Graphics2D) g;
		
		RoundRectangle2D.Double izq = new RoundRectangle2D.Double (2, 15, 200, 635, 5, 5);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(izq);
		
		RoundRectangle2D.Double ap = new RoundRectangle2D.Double (245, 210, 670, 30, 15, 15);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(ap);
		

		
		RoundRectangle2D.Double us = new RoundRectangle2D.Double (245, 310, 670, 30, 15, 15);
		g2d.fill(us);
		
		
		RoundRectangle2D.Double rol = new RoundRectangle2D.Double (245, 410, 200, 30, 15, 15);
		g2d.fill(rol);
		
		RoundRectangle2D.Double cancelar = new RoundRectangle2D.Double (760, 600, 100, 30, 15, 15);
		g2d.fill(cancelar);
		RoundRectangle2D.Double crear = new RoundRectangle2D.Double (870, 600, 75, 30, 15, 15);
		g2d.fill(crear);
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		Font sp =new Font("Microsoft YaHei", Font.ITALIC, 16);
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Ingresa los datos del nuevo vehiculo.", 240,150);		
		
		Font k =new Font("Microsoft YaHei", Font.BOLD, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Marca", 250,233);
		
		g2d.drawString("Modelo", 450,233);
		
		g2d.drawString("Placa", 650,233);
		
		
		
		g2d.drawString("Color", 250,333);
		
		g2d.drawString("Capacidad", 450,333);
		
		g2d.drawString("Transmisión", 650,333);
		
		
		
		g2d.drawString("Categoría", 250,433);
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
			//falta agregar logica que guarde nuevo estado del vehiculo
			interfaz.menuEmpleado();
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