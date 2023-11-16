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
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VistaModVehiculo extends JPanel implements ActionListener {
	
	
	private InterfazEmpresa interfaz;
	
	private JComboBox<String> color;
	private JComboBox<String> capacidad;
	private JComboBox<String> transmision;
	private JComboBox<String> categoria;
	
	
	
	public VistaModVehiculo(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Modificar vehículo");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		
	}
	public void paint(Graphics g) {
		super.paint(g);
			
		Graphics2D g2d = (Graphics2D) g;
		
		RoundRectangle2D.Double izq = new RoundRectangle2D.Double (2, 15, 200, 635, 5, 5);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(izq);
		
		RoundRectangle2D.Double nuevo = new RoundRectangle2D.Double (750, 150, 200, 30, 15, 15);
		g2d.fill(nuevo);
		RoundRectangle2D.Double cancelar = new RoundRectangle2D.Double (760, 600, 100, 30, 15, 15);
		g2d.fill(cancelar);
		RoundRectangle2D.Double guardar = new RoundRectangle2D.Double (870, 600, 93, 30, 15, 15);
		g2d.fill(guardar);
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		Font sp =new Font("Microsoft YaHei", Font.ITALIC, 16);
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Vehiculos", 240,150);
		g2d.setFont(sp);
		
		Font k =new Font("Microsoft YaHei", Font.BOLD, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Nuevo Vehiculo", 771, 173);
		
		Font m =new Font("Microsoft YaHei", Font.PLAIN, 20);
		g2d.setFont(m);
		g2d.setColor(Color.white);
		g2d.drawString("Guardar", 878,623);
		g2d.drawString("Cancelar", 770,623);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}