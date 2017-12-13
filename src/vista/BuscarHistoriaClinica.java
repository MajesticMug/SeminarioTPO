package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import modelo.Paciente;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.HistoriaClinica;

public class BuscarHistoriaClinica extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static BuscarHistoriaClinica inst = null;
	private JList<HistoriaClinica> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarHistoriaClinica frame = new BuscarHistoriaClinica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static BuscarHistoriaClinica getInstance(){
		if(inst == null){
			inst = new BuscarHistoriaClinica();
		}
		return inst;
	}
	
	/**
	 * Create the frame.
	 */
	public BuscarHistoriaClinica() {
		setTitle("Historias Cl\u00EDnicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistoriasClnicas = new JLabel("Historias Cl\u00EDnicas");
		lblHistoriasClnicas.setBounds(10, 11, 173, 14);
		contentPane.add(lblHistoriasClnicas);
		
		list = new JList<HistoriaClinica>();
		list.setBounds(20, 36, 297, 167);
		/*
		DefaultListModel<String> modeloList = new DefaultListModel();
		modeloList.addElement("Historia Clinica 1");
		modeloList.addElement("Historia Clinica 2");
		modeloList.addElement("Historia Clinica 3");
		*/
		DefaultListModel<modelo.HistoriaClinica> modeloList = new DefaultListModel<modelo.HistoriaClinica>();
		
		for (modelo.HistoriaClinica hc : Sistema.getInstance().recuperarHistoriasClinicas()) {
			modeloList.addElement(hc);
		}
		
		list.setModel(modeloList);
		
		contentPane.add(list);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnSeleccionar){
					int dniPaciente = list.getSelectedValue().getPaciente().getNroDocumento();
					vista.HistoriaClinica t = vista.HistoriaClinica.getInstance(dniPaciente);
					t.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnSeleccionar.setBounds(169, 228, 114, 23);
		contentPane.add(btnSeleccionar);
		
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
		btnVolver.setBounds(293, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCrear){
					AltaHistoriaClinica mp = AltaHistoriaClinica.getInstance();
					
					mp.setVentanaBuscar(inst);
					
					mp.setVisible(true);
					inst.setVisible(false);
				}
			}
		});
		btnCrear.setBounds(356, 49, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(356, 88, 89, 23);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				modelo.HistoriaClinica hc = list.getSelectedValue();
				Sistema.getInstance().borrarHistoriaClinica(hc);
				
				DefaultListModel<modelo.HistoriaClinica> model = (DefaultListModel<modelo.HistoriaClinica>)list.getModel();
				
				model.removeElement(hc);
				
				
				
			}
		});
		contentPane.add(btnEliminar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void actualizarHistorias() {
		DefaultListModel<HistoriaClinica> model = (DefaultListModel<HistoriaClinica>) list.getModel();
		model.removeAllElements();
		
		for (HistoriaClinica hc : Sistema.getInstance().getHistoriasClinicas()) {
			model.addElement(hc);
		}
	}
}
