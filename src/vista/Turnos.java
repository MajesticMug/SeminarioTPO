package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import controlador.Sistema;
import modelo.Paciente;
import modelo.Turno;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Turnos extends JFrame implements ActionListener {

	private JDesktopPane contentPane;
	private JButton btnAgregarTurno;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnInfo;
	private JButton btnSeleccionar;
	private JButton btnVolver;
    private static Turnos inst=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Turnos frame = new Turnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Turnos getInstance(){
		if(inst == null){
			inst = new Turnos();
		}
		return inst;
	}
	/**
	 * Create the frame.
	 */
	public Turnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(52, 11, 174, 20);
		contentPane.add(dateChooser);

		JLabel lblTurnos = new JLabel("Turnos");
		lblTurnos.setBounds(10, 11, 46, 20);
		contentPane.add(lblTurnos);

		//		Imagen para boton buscar
		JPanelConFondo panelBuscar = new JPanelConFondo();
		panelBuscar.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Buscar.jpg")));
		panelBuscar.setBounds(10, 181, 76, 70);
		contentPane.add(panelBuscar);
		panelBuscar.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(0, 47, 76, 23);
		panelBuscar.add(btnBuscar);

		//		--------------------------------------------
		JList list = new JList();
		list.setBounds(20, 42, 280, 128);
		DefaultListModel<String> modeloList = new DefaultListModel();
//		List<Turno> listaTurno = Sistema.getInstance().getTurnos();
//		int i = 0;
//		while (i < listaTurno.size()){
//			if (dateChooser.getDate() == listaTurno.get(i).getFechaTurno()){
//			modeloList.addElement(listaTurno.get(i).getPaciente().getNombre() 
//					            + ' ' + listaTurno.get(i).getPaciente().getApellido()
//					            + '-' + listaTurno.get(i).getHoraTurno());
//			}
//		}
		modeloList.addElement("Turno 1");
		modeloList.addElement("Turno 2");
		modeloList.addElement("Turno 3");
		list.setModel(modeloList);
		contentPane.add(list);

//		JScrollPane barra = new JScrollPane(list); 
//		barra.getViewport().add(list); 
//		barra.setBounds(307, 42, 17, 128);
//		contentPane.add(barra);
		//		--------------------------------------------
		//		Panel para agregar Turno
		JPanelConFondo panelAgregar = new JPanelConFondo();
		panelAgregar.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Agregar.jpg")));
		panelAgregar.setBounds(365, 22, 46, 39);
		contentPane.add(panelAgregar);

		btnAgregarTurno = new JButton("Agregar");
		btnAgregarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAgregarTurno){
					AltaTurno o = AltaTurno.getInstance();
					o.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnAgregarTurno.setBounds(345, 61, 89, 23);
		contentPane.add(btnAgregarTurno);

		//		Panel para Modificar
		JPanelConFondo panelModificar = new JPanelConFondo();
		panelModificar.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Modificar.jpg")));
		panelModificar.setBounds(365, 94, 46, 39);
		contentPane.add(panelModificar);

		btnModificar = new JButton("Eliminar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String) list.getSelectedValue();
				
				Turno turno = Sistema.getInstance().buscarTurnos(selected);
				Sistema.getInstance().eliminarTurno(turno);
			}
		});
		btnModificar.setBounds(345, 133, 89, 23);
		contentPane.add(btnModificar);

		//		Panel para Información
		JPanelConFondo panelInfo = new JPanelConFondo();
		panelInfo.setImagen(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/resources/img/Info.jpg")));
		panelInfo.setBounds(96, 181, 89, 70);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnInfo){
					InfoTurno mp = InfoTurno.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
				
			}
		});
		btnInfo.setBounds(0, 47, 89, 23);
		panelInfo.add(btnInfo);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(226, 228, 110, 23);
		contentPane.add(btnSeleccionar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					MenuPrincipal mp = MenuPrincipal.getInstance();
					mp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnVolver.setBounds(345, 228, 89, 23);
		contentPane.add(btnVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		if(e.getSource()==btnAgregarTurno){
			AltaTurno o = AltaTurno.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnBuscar){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnModificar){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnInfo){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnSeleccionar){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnVolver){
			FrameOdontograma o = FrameOdontograma.getInstance();
			o.setVisible(true);
			this.setVisible(false);
		}
	}
}
