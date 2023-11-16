package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PruebaLista extends JPanel implements ActionListener {
	
	
private InterfazEmpresa interfaz;
	
public PruebaLista(InterfazEmpresa interfaz) {

	BorderLayout bl = new BorderLayout();
	setLayout(bl);

	JPanel contenPanel = new JPanel();
	contenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//	setContentPane(contenPanel);
	contenPanel.setLayout(new CardLayout(0,0));

}
		
	
//FLOWLAYOUT, BORDERLAYOUT, GRIDLAYOUT


@Override
public void actionPerformed(ActionEvent e) {
	
	String grito = e.getActionCommand();
		
	if (grito.equals("Empleado")) {
		interfaz.InicioEmpleado();	
	}
	else if (grito.equals("Cliente")) {
		interfaz.InicioCliente();
	}
		
}
	
}

