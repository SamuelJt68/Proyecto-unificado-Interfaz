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

public class VistaCrearSede extends JPanel implements ActionListener {
	
	
	private InterfazEmpresa interfaz;
	
	private JTextField textNombre;
	private JTextField textDireccion;
	private JComboBox<String> horaApertura;
	private JComboBox<String> horaCierre;
	private JComboBox<String> admiLocal;
	
	public VistaCrearSede(InterfazEmpresa interfaz) {

		this.interfaz = interfaz;
		
		TitledBorder border = new TitledBorder("Crear nueva sede");
		setBorder(border);
		setPreferredSize(new Dimension(1000,700));
		setBackground(Color.WHITE);
		setLayout(null);
		textNombre = new JTextField();
		textNombre.setBounds(250, 243, 180, 25);
		textDireccion = new JTextField();
		textDireccion.setBounds(450, 243, 300, 25);
		add(textNombre);
		add(textDireccion);
		
		String[] horas = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
		String[] empleados = {"Juancito","Mariita","Graceita", "Juliancito", "Leidicita", "Samuelito"};

        
        horaApertura = new JComboBox<>(horas);
        horaApertura.setActionCommand("HORA DE APERTURA");
        horaApertura.addActionListener(this);
        
        horaApertura.setBounds(250, 343, 180, 25);
        
        horaCierre = new JComboBox<>(horas);
        horaCierre.setActionCommand("HORA DE CIERRE");
        horaCierre.addActionListener(this);
        
        horaCierre.setBounds(450, 343, 180, 25);

        
        admiLocal = new JComboBox<>(empleados);
        admiLocal.setActionCommand("ADMINISTRADOR DE SEDE");
        admiLocal.addActionListener(this);
        
        admiLocal.setBounds(250, 443, 300, 25);

		
        add(horaApertura);
        add(horaCierre);
        add(admiLocal);

        
		
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
		
		RoundRectangle2D.Double con = new RoundRectangle2D.Double (245, 410, 670, 30, 15, 15);
		g2d.fill(con);
		
	
		
		RoundRectangle2D.Double cancelar = new RoundRectangle2D.Double (760, 600, 100, 30, 15, 15);
		g2d.fill(cancelar);
		RoundRectangle2D.Double crear = new RoundRectangle2D.Double (870, 600, 75, 30, 15, 15);
		g2d.fill(crear);
		
		Font s =new Font("Microsoft YaHei", Font.BOLD, 35);
		Font sp =new Font("Microsoft YaHei", Font.ITALIC, 16);
		g2d.setColor(Color.black);
		
		g2d.setFont(s);
		
		g2d.drawString("Ingresa los datos de la nueva sede.", 240,150);
		
		
		Font k =new Font("Microsoft YaHei", Font.BOLD, 20);
		
		g2d.setColor(Color.white);
		
		g2d.setFont(k);
		
		g2d.drawString("Nombre", 250,233);
		
		g2d.drawString("Dirección", 450,233);
		
		
		
		
		g2d.drawString("Horario Apertura", 250,333);
		
		g2d.drawString("Horario Cierre", 450,333);
		g2d.drawString("Administrador local", 250,433);
				
		
		Font m =new Font("Microsoft YaHei", Font.PLAIN, 20);
		g2d.setFont(m);
		g2d.setColor(Color.white);
		g2d.drawString("Crear", 880,623);
		g2d.drawString("Cancelar", 770,623);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}