package vista;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MenuPrincipal extends JFrame implements ActionListener{

	private JDesktopPane contentPane;
	private JButton btnInformacion;
	private JButton btnPacientes;
	private JButton btnEspecialistas;
	private JButton btnTurnos;
	private JButton btnHistoriasClinicas;
	private JButton btnRadiografias;
	private JButton btnBuscar;
	private static MenuPrincipal inst = null;

	/**
	 * Launch the application.
	 */
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
	public static MenuPrincipal getInstance(){
		if(inst == null){
			inst = new MenuPrincipal();
		}
		return inst;
	}
	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		super();
		inst = this;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Centro Odontol\u00F3gico Integral");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnInformacion = new JButton("Informaci\u00F3n");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnInformacion){
					InfoMenuPpal t = InfoMenuPpal.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnInformacion.setBounds(218, 198, 105, 23);
		contentPane.add(btnInformacion);

		//		LOGO Centro
		JPanelConFondo panelLogo = new JPanelConFondo();
		panelLogo.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/LogoCentro.jpg")));
		panelLogo.setBounds(340, 28, 139, 110);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);

		//		Imagen para boton Pacientes
		JPanelConFondo panelPaciente = new JPanelConFondo();
		panelPaciente.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/NuevoPaciente.jpg")));
		panelPaciente.setBounds(10, 28, 99, 69);
		contentPane.add(panelPaciente);
		panelPaciente.setLayout(null);

		btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPacientes){
					AdministrarPacientes t = AdministrarPacientes.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
				
			}
		});
		btnPacientes.setBounds(0, 46, 99, 23);
		panelPaciente.add(btnPacientes);

		//		Imagen para boton Especialistas
		JPanelConFondo panelEspecialistas = new JPanelConFondo();
		panelEspecialistas.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/NuevoEspecialista.jpg")));
		panelEspecialistas.setBounds(119, 28, 116, 69);
		contentPane.add(panelEspecialistas);
		panelEspecialistas.setLayout(null);

		btnEspecialistas = new JButton("Especialistas");
		btnEspecialistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnEspecialistas){
					AdministrarEspecialistas t = AdministrarEspecialistas.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnEspecialistas.setBounds(0, 46, 116, 23);
		panelEspecialistas.add(btnEspecialistas);

		//		Imagen para Boton Turnos
		JPanelConFondo panelTurnos = new JPanelConFondo();
		panelTurnos.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Turnos.jpg")));
		panelTurnos.setBounds(241, 28, 89, 69);
		contentPane.add(panelTurnos);
		panelTurnos.setLayout(null);

		btnTurnos = new JButton("Turnos");
		btnTurnos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
								
				if(e.getSource()==btnTurnos){
					Turnos t = Turnos.getInstance();
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
			
		});
		btnTurnos.setBounds(0, 46, 84, 23);
		panelTurnos.add(btnTurnos);

		//		Imagen para boton Historias Clínicas
		JPanelConFondo panelHC = new JPanelConFondo();
		panelHC.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/HistoriasClinicas.jpg")));
		panelHC.setBounds(10, 149, 100, 72);
		contentPane.add(panelHC);
		panelHC.setLayout(null);

		btnHistoriasClinicas = new JButton("Historias C.");
		btnHistoriasClinicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnHistoriasClinicas){
					BuscarHistoriaClinica hc = BuscarHistoriaClinica.getInstance();
					hc.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnHistoriasClinicas.setBounds(0, 49, 100, 23);
		panelHC.add(btnHistoriasClinicas);
		btnHistoriasClinicas.setToolTipText("Historias Cl\u00EDnicas");

/*
		//      Imagen para boton Radiografías
		JPanelConFondo panelRadiog = new JPanelConFondo();
		panelRadiog.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Radiografias.jpg")));
		panelRadiog.setBounds(119, 148, 110, 73);
		contentPane.add(panelRadiog);
		panelRadiog.setLayout(null);

		btnRadiografias = new JButton("Radiograf\u00EDas");
		btnRadiografias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRadiografias){
					FrameRadiografias r = FrameRadiografias.getInstance();
					r.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnRadiografias.setBounds(0, 50, 107, 23);
		panelRadiog.add(btnRadiografias);
*/
		//		Imagen para boton buscar
		JPanelConFondo panelBuscar = new JPanelConFondo();
		panelBuscar.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Buscar.jpg")));
		panelBuscar.setBounds(119, 149, 89, 72);
		contentPane.add(panelBuscar);
		panelBuscar.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBuscar){
					BuscarPersona bp = BuscarPersona.getInstance();
					bp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnBuscar.setBounds(0, 49, 89, 23);
		panelBuscar.add(btnBuscar);

		//		Imagen para boton Información		
		JPanelConFondo panelInfo = new JPanelConFondo();
		panelInfo.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Info.jpg")));
		panelInfo.setBounds(218, 149, 105, 62);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		if(e.getSource()==btnInformacion){
			FrameInformacion i = FrameInformacion.getInstance();
			i.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnPacientes){
			FrameInformacion i = FrameInformacion.getInstance();
			i.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnEspecialistas){
			FrameInformacion i = FrameInformacion.getInstance();
			i.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnTurnos){
			Turnos t = Turnos.getInstance();
			t.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnHistoriasClinicas){
//			FrameInformacion i = FrameInformacion.getInstance();
//			i.setVisible(true);
//			this.setVisible(false);
		}
		if(e.getSource()==btnRadiografias){
			FrameRadiografias r = FrameRadiografias.getInstance();
			r.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnBuscar){
//			FrameBuscar i = FrameBuscar.getInstance();
//			i.setVisible(true);
//			this.setVisible(false);
		}
	}
}

