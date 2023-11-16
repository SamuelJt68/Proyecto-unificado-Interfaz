package Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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

public class VistaDispo extends JPanel implements ActionListener {

    private JLabel labelPeticion;
    private JLabel labelCategoria;
    private JLabel labelFechaInicial;
    private JLabel labelFechaFinal;
    private JLabel labelSedeRecogida;
    private JLabel labelSedeEntrega;
    private JLabel labelHoraEntrega;
    private JLabel labelDisponibilidad;

    private JTextField tCategoria;
    private JTextField tFechaInicial;
    private JTextField tFechaFinal;
    private JTextField tSedeRecogida;
    private JTextField tSedeEntrega;
    private JTextField tHoraEntrega;

    private BotonRedondeado disponibilidad;
    private BotonRedondeado realizarPago;
    private BotonRedondeado volver;

    private InterfazEmpresa interfaz;

    public VistaDispo(InterfazEmpresa interfaz) {

        this.interfaz = interfaz;

        TitledBorder border = new TitledBorder("Crear nueva reserva");
        setBorder(border);
        setPreferredSize(new Dimension(1000, 700));

        initUI();
    }

    private void initUI() {
    	
        setLayout(new FlowLayout());

        labelPeticion = createLabel("Ingrese los siguientes datos:");
        labelCategoria = createLabel("Categoría:");
        labelFechaInicial = createLabel("Fecha inicial:");
        labelFechaFinal = createLabel("Fecha final:");
        labelSedeRecogida = createLabel("Sede de recogida:");
        labelSedeEntrega = createLabel("Sede de entrega:");
        labelHoraEntrega = createLabel("Hora de entrega:");
        labelDisponibilidad = createLabel("Disponibilidad");


        tCategoria = createTextField();
        tFechaInicial = createTextField();
        tFechaFinal = createTextField();
        tSedeRecogida = createTextField();
        tSedeEntrega = createTextField();
        tHoraEntrega = createTextField();

        disponibilidad = new BotonRedondeado("Disponibilidad");
        disponibilidad.addActionListener(this);

        realizarPago = new BotonRedondeado("Realizar Pago");
        realizarPago.addActionListener(this);

        volver = new BotonRedondeado("Volver");
        volver.addActionListener(this);

        add(labelPeticion);
        add(labelCategoria);
        add(tCategoria);
        add(labelFechaInicial);
        add(tFechaInicial);
        add(labelFechaFinal);
        add(tFechaFinal);
        add(labelSedeRecogida);
        add(tSedeRecogida);
        add(labelSedeEntrega);
        add(tSedeEntrega);
        add(labelHoraEntrega);
        add(tHoraEntrega);
        add(labelDisponibilidad);
        add(disponibilidad);
        
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(volver);
        buttonBox.add(Box.createHorizontalStrut(20)); 
        buttonBox.add(realizarPago);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonBox);
        
        add(buttonPanel);
        
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
        
		String catgoria = tCategoria.getText();
		String fechaInicial = tFechaInicial.getText();
		String fechaFinal = tFechaFinal.getText();
		String sedeRecogida = tSedeRecogida.getText();
		String sedeEntrega = tSedeEntrega.getText();
		String horaEntrega = tHoraEntrega.getText();

        if (command.equals("Disponibilidad")) {
            // crear nuevo usuario a interfaz
            interfaz.vistaDispo();
            
        } else if (command.equals("Volver")) {
            interfaz.menuCliente();
            
        } else if (command.equals("Realizar pago")) {
        	interfaz.vistaPago();
        }
    }
}

