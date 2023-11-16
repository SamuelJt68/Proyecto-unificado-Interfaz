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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VistaAdmiLocal extends JPanel implements ActionListener, MouseListener {
	
	
	private InterfazEmpresa interfaz;
	
	public VistaAdmiLocal(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Menú administrador local");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		addMouseListener(this);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
			
		Graphics2D g2d = (Graphics2D) g;
		

		RoundRectangle2D.Double gestion = new RoundRectangle2D.Double (245, 210, 500, 30, 15, 15);
		g2d.setColor(new Color (232, 30, 74));
		g2d.fill(gestion);
		
		
		
		RoundRectangle2D.Double cerrar = new RoundRectangle2D.Double (420, 600, 150, 30, 15, 15);
		g2d.fill(cerrar);
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Selecciona la acción a realizar", 240,150);
		
		Font k =new Font("Microsoft YaHei", Font.PLAIN, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Gestionar empleados de sede", 360,233);

		
		
		g2d.drawString("Cerrar Sesión", 430,623);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		int clickEY = e.getY();
		int clickEX = e.getX();
		//cerrar sesión
		if ((600<clickEY)&&(clickEY<630) && (420<clickEX)&&(clickEX<570)){
			interfaz.InicioEmpleado();

		}
		//gestionar empleados
		else if ((210<clickEY)&&(clickEY<240) && (245<clickEX)&&(clickEX<745)){
			interfaz.InicioEmpleado();;

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