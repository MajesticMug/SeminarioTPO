package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoTurno extends JFrame {

	private JPanel contentPane;
	private static InfoTurno inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoTurno frame = new InfoTurno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static InfoTurno getInstance(){
		if(inst == null){
			inst = new InfoTurno();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public InfoTurno() {
		setTitle("Informaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformacinSobreEl = new JLabel("Informaci\u00F3n sobre el turno");
		lblInformacinSobreEl.setBounds(10, 11, 166, 14);
		contentPane.add(lblInformacinSobreEl);
		
		JTextPane txtpnElPaciente = new JTextPane();
		txtpnElPaciente.setText("- El paciente solicita turno por dolor intenso en muela. Se encuentra anticoagulado y tomando medicaci\u00F3n card\u00EDaca.");
		txtpnElPaciente.setBounds(20, 36, 303, 181);
		contentPane.add(txtpnElPaciente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnVolver){
					Turnos o = Turnos.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}	
			}
		});
		btnVolver.setBounds(335, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(240, 228, 89, 23);
		contentPane.add(btnGrabar);
	}
}
