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

public class VistaModSeguro extends JPanel implements ActionListener, MouseListener {
	
	
	private InterfazEmpresa interfaz;
	
	private JTextField textNombre;
	private JComboBox<String> precio;


	
	public VistaModSeguro(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Modificar seguro");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		setLayout(null);
		addMouseListener(this);
		textNombre = new JTextField();
		textNombre.setBounds(250, 243, 180, 25);
		add(textNombre);

		String[] precios = {"$5", "$6", "$7", "$8", "$9", "$10", "$11", "$12", "$13", "$14", "$15", "$16", "$17", "$18", "$19", "$20", "$21", "$22", "$23", "$24", "$25", "$26", "$27", "$28", "$29", "$30", "$31", "$32", "$33", "$34", "$35", "$36", "$37", "$38", "$39", "$40", "$41", "$42", "$43", "$44", "$45", "$46", "$47", "$48", "$49", "$50", "$51", "$52", "$53", "$54", "$55", "$56", "$57", "$58", "$59", "$60", "$61", "$62", "$63", "$64", "$65", "$66", "$67", "$68", "$69", "$70", "$71", "$72", "$73", "$74", "$75", "$76", "$77", "$78", "$79", "$80", "$81", "$82", "$83", "$84", "$85", "$86", "$87", "$88", "$89", "$90", "$91", "$92", "$93", "$94", "$95", "$96", "$97", "$98", "$99", "$100"};

        precio= new JComboBox<>(precios);
        precio.setActionCommand("PRECIO SEGURO");
        precio.addActionListener(this);
        
        precio.setBounds(450, 243, 180, 25);


        add(precio);
        
		
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
		

	
	
		
		RoundRectangle2D.Double cancelar = new RoundRectangle2D.Double (760, 600, 100, 30, 15, 15);
		g2d.fill(cancelar);
		RoundRectangle2D.Double guardar = new RoundRectangle2D.Double (870, 600, 93, 30, 15, 15);
		g2d.fill(guardar);
		
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		Font sp =new Font("Microsoft YaHei", Font.ITALIC, 16);
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Ingresa los datos nuevos del seguro.", 240,150);
		g2d.setFont(sp);
		g2d.drawString("Si no haces cambios en una casilla, los datos previos permanecerán.", 240,180);

		
		
		Font k =new Font("Microsoft YaHei", Font.BOLD, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Nombre", 250,233);
		
		g2d.drawString("Precio", 450,233);
		
		
		
		
		Font m =new Font("Microsoft YaHei", Font.PLAIN, 20);
		g2d.setFont(m);
		g2d.setColor(Color.white);
		g2d.drawString("Guardar", 878,623);
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
			interfaz.InicioEmpleado();

		}
		//guardar nueva info seguro
		else if ((600<clickEY)&&(clickEY<630) && (870<clickEX)&&(clickEX<963)){
			//falta agregar logica que guarde nuevo estado del vehiculo
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