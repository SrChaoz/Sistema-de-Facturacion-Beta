package ec.edu.puce.facturacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private Infoclientes infoclientes = new Infoclientes(); 
    private FrmCliente frmCliente;
    private ListaCliente listaCliente;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        setTitle("SISTEMA DE FACTURACIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 509);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(87, 227, 137));
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        mnFile.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnFile);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
        mnFile.add(mntmSalir);

        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu mnClientes = new JMenu("Clientes");
        mnClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnClientes);

        JMenuItem mntmCrearClientes = new JMenuItem("Crear Clientes");

        mntmCrearClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCliente == null || !frmCliente.isVisible()) {
                    frmCliente = new FrmCliente(infoclientes);
                    desktopPane.add(frmCliente);
                    frmCliente.setVisible(true);
                } else {
                    frmCliente.requestFocus();
                }
            }
        });

        mntmCrearClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        mnClientes.add(mntmCrearClientes);

        JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
        mntmListaDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        mnClientes.add(mntmListaDeClientes);

        mntmListaDeClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaCliente == null || !listaCliente.isVisible()) {
                    listaCliente = new ListaCliente(infoclientes);
                    desktopPane.add(listaCliente);
                    listaCliente.setVisible(true);
                } else {
                    listaCliente.requestFocus();
                }
            }
        });

        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnProductos);

        JMenuItem mntmCrearProducto = new JMenuItem("Crear Producto");
        mntmCrearProducto.setFont(new Font("Dialog", Font.BOLD, 16));
        mnProductos.add(mntmCrearProducto);

        JMenuItem mntmListaDeProductos = new JMenuItem("Lista de Productos");
        mntmListaDeProductos.setFont(new Font("Dialog", Font.BOLD, 16));
        mnProductos.add(mntmListaDeProductos);

        JMenu mnRedesSociales = new JMenu("Redes sociales");
        mnRedesSociales.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ec/edu/puce/facturacion/imagenes/facebook.png")));
        mnRedesSociales.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnRedesSociales);

        JMenuItem mntmFacebook = new JMenuItem("Facebook");
        mntmFacebook.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ec/edu/puce/facturacion/imagenes/facebook.png")));
        mntmFacebook.setFont(new Font("Dialog", Font.BOLD, 16));
        mnRedesSociales.add(mntmFacebook);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(222, 221, 218));
        contentPane.add(desktopPane, "name_250806999939613");
    }
}
