package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import modelo.HistoriaClinica;
import modelo.Paciente;
import modelo.PuntosMarcados;
import utils.HibernateUtil;

public class FrameOdontograma extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton abonos;
	private JButton personal;
	private JButton convenios;
	private JLabel Administracion;
	private static FrameOdontograma inst=null;
	private static final long serialVersionUID = 1332996636763672080L;

	private List<Point> points = new ArrayList<Point>();

	private Image background;

	public Paciente paciente;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOdontograma frame = new FrameOdontograma(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//				inst.setLocationRelativeTo(null);
				//				inst.setVisible(true);
			}
		});
	}

	public static FrameOdontograma getInstance(Paciente p) throws IOException{
		if(inst == null){
			inst = new FrameOdontograma(p);
		}
		return inst;
	}

	FrameOdontograma(Paciente p) {
		super();
		initGUI(p);
	}

	private void initGUI(Paciente p) {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			this.paciente = p;

			initialize();

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent event) {
					points.add(event.getPoint());

					repaint();
				}
			});

			background = ImageIO.read(new File("src/resources/img/FormularioDental.jpg"));
			pack();
			this.setSize(650, 330);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void paint(java.awt.Graphics g) {
		super.paint(g);

		g.drawImage(background, 0, 20, this);

		g.setColor(Color.red);
		for (Point p : points)
			g.fillOval(p.x - 5, p.y - 5, 10, 10);
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setBounds(100, 100, 700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarFicha();
			}
		});
		btnGuardar.setBounds(10, 250, 89, 23);
		getContentPane().add(btnGuardar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					vista.HistoriaClinica o = vista.HistoriaClinica.getInstance(paciente.getNroDocumento());
					o.setVisible(true);
					inst.setVisible(false);
				}	
			}
		});
		btnVolver.setBounds(100, 250, 89, 23);
		getContentPane().add(btnVolver);
	}

	private void guardarFicha() {

		Date fecha = new Date(new java.util.Date().getTime());

		Paciente paciente = new Paciente("OSDE", 123, "Javier", "Capello", "DNI", 1000000, "Calle falsa 123",
				123123, 'm', fecha, "PAC", "jcapello","jcapello");

		HistoriaClinica historiaClinica = new HistoriaClinica("", paciente);

		List<Integer> puntosX = new ArrayList<Integer>();
		List<Integer> puntosY = new ArrayList<Integer>();

		for (Point p : points)
		{
			puntosX.add(p.x);
			puntosY.add(p.y);
		}

		PuntosMarcados puntosMarcados = new PuntosMarcados(puntosX, puntosY);

		modelo.FichaOdontologica ficha = new modelo.FichaOdontologica(fecha, fecha, 
				paciente, "", historiaClinica, puntosMarcados);

		HibernateUtil.guardarEntidad(puntosMarcados);
		HibernateUtil.guardarEntidad(paciente);
		HibernateUtil.guardarEntidad(historiaClinica);
		HibernateUtil.guardarEntidad(ficha);
	}

}
