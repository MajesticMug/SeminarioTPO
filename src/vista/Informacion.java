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

public class Informacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtErnestoBonacua;
	private static Informacion inst = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacion frame = new Informacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Informacion getInstance(){
		if(inst == null){
			inst = new Informacion();
		}
		return inst;
	}

	
	/**
	 * Create the frame.
	 */
	public Informacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(203, 228, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btnVolver){
					HistoriaClinica t = HistoriaClinica.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(302, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(10, 11, 76, 14);
		contentPane.add(lblPaciente);
		
		txtErnestoBonacua = new JTextField();
		txtErnestoBonacua.setText("Ernesto Bonacua");
		txtErnestoBonacua.setEditable(false);
		txtErnestoBonacua.setBounds(135, 8, 208, 20);
		contentPane.add(txtErnestoBonacua);
		txtErnestoBonacua.setColumns(10);
		
		JTextPane txtpnPacienteHemofilico = new JTextPane();
		txtpnPacienteHemofilico.setText("- Paciente Hemofilico\r\n- Grupo y Factor 0+");
		txtpnPacienteHemofilico.setBounds(20, 36, 404, 181);
		contentPane.add(txtpnPacienteHemofilico);
	}
}
