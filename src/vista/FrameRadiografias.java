package vista;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class FrameRadiografias extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton abonos;
	private JButton personal;
	private JButton convenios;
	private JLabel Administracion;
    private static FrameRadiografias inst=null;
	private JTextField txtPaciente;
    /**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameRadiografias inst = new FrameRadiografias();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private FrameRadiografias() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 518, 304);
			contenedor = new JDesktopPane();
			contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contenedor);
			contenedor.setLayout(null);

			JLabel lblRadiografas = new JLabel("Radiograf\u00EDas ");
			lblRadiografas.setBounds(10, 11, 91, 14);
			contenedor.add(lblRadiografas);

			txtPaciente = new JTextField();
			txtPaciente.setEditable(false);
			txtPaciente.setText("Ernesto Bonacua");
			txtPaciente.setBounds(80, 8, 229, 20);
			contenedor.add(txtPaciente);
			txtPaciente.setColumns(10);

			JList list = new JList();
			list.setBounds(21, 47, 229, 144);
			DefaultListModel<String> modeloList = new DefaultListModel();
			modeloList.addElement("Radiografía 1");
			modeloList.addElement("Radiografía 2");
			modeloList.addElement("Radiografía 3");
			list.setModel(modeloList);
			contenedor.add(list);

			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(111, 228, 89, 23);
			contenedor.add(btnAceptar);

			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(210, 228, 89, 23);
			contenedor.add(btnEliminar);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==btnVolver){
						MenuPrincipal mp = MenuPrincipal.getInstance();
						mp.setVisible(true);
						inst.setVisible(false);
					}
				}
			});
			btnVolver.setBounds(309, 228, 89, 23);
			contenedor.add(btnVolver);

			JPanelConFondo panelRadiografia = new JPanelConFondo();
			panelRadiografia.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Radiografias1.jpg")));
			panelRadiografia.setBounds(260, 51, 164, 100);
			contenedor.add(panelRadiografia);
			panelRadiografia.setLayout(null); 
			
//			pack();
//			this.setSize(518, 304);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FrameRadiografias getInstance(){
		if(inst == null){
			inst = new FrameRadiografias();
		}
		return inst;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
