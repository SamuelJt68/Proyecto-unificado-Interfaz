package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setForeground(Color.WHITE);
        setBackground(new Color(0, 0, 255)); 
        setText("Modificar");
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    private final JButton button;
    private final JPanel panel;

    public ButtonEditor(JCheckBox checkBox, ActionListener actionListener) {
        super(checkBox);
        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(e -> {
            fireEditingStopped();
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Pagar"));
        });
        this.panel = new JPanel(new BorderLayout());
        this.panel.add(this.button);
        this.panel.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.button.setForeground(Color.WHITE);
        this.button.setBackground(new Color(0, 0, 255)); 
        this.button.setText("Modificar");
        return this.panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "Modificar";
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

public class VistaRealizarPago extends JPanel implements ActionListener {


	private InterfazEmpresa interfaz;
	private JButton pagar;
	private JButton volver;
		
	
	
	public VistaRealizarPago(InterfazEmpresa interfaz) {
		
		 this.interfaz = interfaz;

	     TitledBorder border = new TitledBorder("Realizar pago");
	     setBorder(border);
	     setPreferredSize(new Dimension(1000, 700));
	     
	     setLayout(null);
	     pagar = new JButton("Pagar");
	     pagar.setBounds(870, 600, 93, 30);
	     pagar.setActionCommand("PAGAR");
	     pagar.addActionListener(this);
	     volver = new JButton("Volver");
	     volver.setBounds(760, 600, 100, 30);
	     volver.setActionCommand("VOLVER");
	     volver.addActionListener(this);
	     add(pagar);
	     add(volver);

	     initUI();
		
	}

	@Override
public void actionPerformed(ActionEvent e) {
        
		String grito = e.getActionCommand();
			
		if (grito.equals("VOLVER")) {
			interfaz.vistaNuevaReserva();
		}
		else if (grito.equals("PAGAR")) {
			//agregar logica para que se realice el pago
			interfaz.menuCliente();
		}
			

	}
	
	private void initUI() {
	    setLayout(new BorderLayout());

	
	    JPanel fondoRojo = new JPanel();
	    fondoRojo.setBackground(new Color(255, 0, 0)); 
	    fondoRojo.setLayout(new BorderLayout());

	    JLabel etiquetaHistorial = new JLabel("Realizar Pago");
	    etiquetaHistorial.setForeground(Color.white);
	    etiquetaHistorial.setFont(new Font("Arial", Font.BOLD, 20));
	    etiquetaHistorial.setHorizontalAlignment(JLabel.CENTER);
	    fondoRojo.add(etiquetaHistorial, BorderLayout.CENTER);

	    
	    JPanel panelSinFondo = new JPanel();
	    panelSinFondo.setLayout(new BorderLayout());


	    JLabel tituloReservas = new JLabel("Metodos de pago");
	    tituloReservas.setFont(new Font("Arial", Font.BOLD, 20));
	    tituloReservas.setHorizontalAlignment(JLabel.CENTER);
	    panelSinFondo.add(tituloReservas, BorderLayout.NORTH);
	    
	    DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; 
            }
        };

	    modeloTabla.addColumn("Tarjeta");
	    modeloTabla.addColumn("Nombre titular");
	    modeloTabla.addColumn("Estado");
	    modeloTabla.addColumn("Pagar");

	    JTable tablaReservas = new JTable(modeloTabla);
	    
	    tablaReservas.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        tablaReservas.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), this));


	  
	    panelSinFondo.add(new JScrollPane(tablaReservas), BorderLayout.CENTER);

	   
	    add(fondoRojo, BorderLayout.WEST);
	    add(panelSinFondo, BorderLayout.CENTER);

	    
	}

}