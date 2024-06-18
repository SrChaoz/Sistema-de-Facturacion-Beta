package ec.edu.puce.facturacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ListaCliente extends JInternalFrame {
    private JTable table;
    private Infoclientes infoclientes;
    private DefaultTableModel model;
    private FrmCliente frmCliente;
    
    public ListaCliente(Infoclientes infoclientes) {
    	getContentPane().setBackground(new Color(153, 193, 241));
        this.infoclientes = infoclientes;
        setTitle("Clientes");
        setBounds(100, 100, 450, 558);
        getContentPane().setLayout(null);

        JButton btnCancelar = new JButton("Salir");
        btnCancelar.setBounds(281, 478, 117, 25);
        btnCancelar.setBackground(new Color(246, 97, 81));
        getContentPane().add(btnCancelar);
        
        
        //No concrete la implementacion
        
      /*JButton btnNuevo = new JButton("Limpiar Lista");
        btnNuevo.setBounds(23, 478, 117, 25);
        btnNuevo.setBackground(new Color(143, 240, 164));
        getContentPane().add(btnNuevo);
        
       btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
            }
        });
	*/
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 11, 375, 454);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        cargarClientes();
    }

    private void cargarClientes() {
        model.setRowCount(0); 
        List<Cliente> listaClientes = infoclientes.getListaClientes();
        for (Cliente cliente : listaClientes) {
            agregarFila(cliente);
        }
    }

    private void agregarFila(Cliente cliente) {
        Object[] fila = new Object[6];
        fila[0] = cliente.getCedula();
        fila[1] = cliente.getNombre();
        fila[2] = cliente.getApellido();
        fila[3] = cliente.getDireccion();
        fila[4] = cliente.getTelefono();
        fila[5] = cliente.getEmail();
        model.addRow(fila);
    }
}