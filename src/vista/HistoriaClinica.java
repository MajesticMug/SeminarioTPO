package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.Paciente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HistoriaClinica extends JFrame implements ActionListener{

	private JDesktopPane contentPane;
	private JTextField txtPaciente;
	private int dniPaciente;
	private JButton btnOdontograma;
	private JButton btnPendientes;
	private JButton btnCronologia;
	private JButton btnFotos;
	private JButton btnRadiografias;
	private JButton btnInfo;
    private static HistoriaClinica inst=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoriaClinica frame = new HistoriaClinica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static HistoriaClinica getInstance(){
		if(inst == null){
			inst = new HistoriaClinica();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public HistoriaClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHistoriaClnicaDel = new JLabel("Historia Cl\u00EDnica del Paciente: ");
		lblHistoriaClnicaDel.setBounds(10, 11, 165, 14);
		contentPane.add(lblHistoriaClnicaDel);

		txtPaciente = new JTextField();
		txtPaciente.setText("Ernesto Bonacua");
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(185, 8, 183, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);

		//		Panel Imagen Odontograma
		JPanelConFondo panelOdontograma = new JPanelConFondo();
		panelOdontograma.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Sonrisa.jpg")));
		panelOdontograma.setBounds(22, 60, 65, 52);
		contentPane.add(panelOdontograma);

		btnOdontograma = new JButton("Odontograma");
		btnOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnOdontograma){
					Paciente p = controlador.Sistema.getInstance().buscarPaciente(dniPaciente);
					FichaOdontologica o = null;
					try {
						o = FichaOdontologica.getInstance(p);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					o.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnOdontograma.setBounds(1, 116, 120, 23);
		contentPane.add(btnOdontograma);

		btnPendientes = new JButton("Pendientes");
		btnPendientes.setBounds(131, 116, 104, 23);
		contentPane.add(btnPendientes);

		btnCronologia = new JButton("Cronolog\u00EDa");
		btnCronologia.setBounds(0, 216, 104, 23);
		contentPane.add(btnCronologia);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnInfo){
					Informacion t = Informacion.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnInfo.setBounds(327, 216, 89, 23);
		contentPane.add(btnInfo);

		JButton btnFotos = new JButton("Fotos");
		btnFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnFotos){
					Fotos f = Fotos.getInstance();
					f.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnFotos.setBounds(114, 216, 89, 23);
		contentPane.add(btnFotos);

		//		Panel Imagen Cronologia
		JPanelConFondo panelCronologia = new JPanelConFondo();
		panelCronologia.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Cronologia.jpg")));
		panelCronologia.setBounds(19, 162, 68, 52);
		contentPane.add(panelCronologia);

		//		Panel imagen Fotos
		JPanelConFondo panelFotos = new JPanelConFondo();
		panelFotos.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Fotos.jpg")));
		panelFotos.setBounds(126, 171, 65, 43);
		contentPane.add(panelFotos);

		//		Panel Imagen Radiografías
		JPanelConFondo panelRadiografias = new JPanelConFondo();
		panelRadiografias.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Radiografias.jpg")));
		panelRadiografias.setBounds(213, 171, 104, 67);
		contentPane.add(panelRadiografias);
		panelRadiografias.setLayout(null);

		btnRadiografias = new JButton("Radiograf\u00EDas");
		btnRadiografias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRadiografias){
					Radiografias r = Radiografias.getInstance();
					r.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnRadiografias.setBounds(0, 44, 108, 23);
		panelRadiografias.add(btnRadiografias);

		//		Panel Imagen Información
		JPanelConFondo panelInfo = new JPanelConFondo();
		panelInfo.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Info2.jpg")));
		panelInfo.setBounds(346, 171, 51, 43);
		contentPane.add(panelInfo);

		//		Panel Imagen Pendientes
		JPanelConFondo panelPendientes = new JPanelConFondo();
		panelPendientes.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Pendientes.jpg")));
		panelPendientes.setBounds(149, 60, 65, 52);
		contentPane.add(panelPendientes);

		//		Foto Paciente
		JPanelConFondo panelPaciente = new JPanelConFondo();
		panelPaciente.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Paciente1.jpg")));
		panelPaciente.setBounds(278, 39, 119, 103);
		contentPane.add(panelPaciente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					MenuPrincipal o = MenuPrincipal.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(327, 239, 89, 23);
		contentPane.add(btnVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOdontograma){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnPendientes){
			FramePendientes p = FramePendientes.getInstance();
			p.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnCronologia){
			FrameCronologia c = FrameCronologia.getInstance();
			c.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnFotos){
			FrameFotos f = FrameFotos.getInstance();
			f.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnRadiografias){
			FrameRadiografias r = FrameRadiografias.getInstance();
			r.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnInfo){
			FrameInformacion i = FrameInformacion.getInstance();
			i.setVisible(true);
			this.setVisible(false);
		}

	}
}
