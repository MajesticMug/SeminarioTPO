package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoMenuPpal extends JFrame {

	private JPanel contentPane;
	private static InfoMenuPpal inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoMenuPpal frame = new InfoMenuPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static InfoMenuPpal getInstance(){
		if(inst == null){
			inst = new InfoMenuPpal();
		}
		return inst;
	}

	
	/**
	 * Create the frame.
	 */
	public InfoMenuPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btnVolver){
					MenuPrincipal t = MenuPrincipal.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(302, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JTextPane txtpnCentroOdontolgicoIntegral = new JTextPane();
		txtpnCentroOdontolgicoIntegral.setText("Centro Odontol\u00F3gico Integral \r\n---------------------------------\r\nVersion: COI Release (1.0.0)\r\nBuild id: 20161208-0600");
		txtpnCentroOdontolgicoIntegral.setEditable(false);
		txtpnCentroOdontolgicoIntegral.setBounds(10, 11, 414, 206);
		contentPane.add(txtpnCentroOdontolgicoIntegral);
	}
}
