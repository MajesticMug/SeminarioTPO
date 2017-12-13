package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import modelo.HistoriaClinica;
import modelo.Paciente;
import modelo.PuntosMarcados;
import javax.swing.JButton;

import utils.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FichaOdontologica extends JFrame {
	
	
	/**
	 * 
	 */
	private static FichaOdontologica inst = null;
	private static final long serialVersionUID = 1332996636763672080L;

	private List<Point> points = new ArrayList<Point>();

	private Image background;

	public Paciente paciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FichaOdontologica window = new FichaOdontologica(null);
					window.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public FichaOdontologica(Paciente paciente) throws IOException
	{
		setTitle("Ficha Odontol\u00F3gica");
		this.paciente = paciente;

		initialize();

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				points.add(event.getPoint());

				repaint();
			}
		});

		background = ImageIO.read(new File("src/resources/img/FormularioDental.jpg"));
	}
	public static FichaOdontologica getInstance(Paciente p) throws IOException{
		if(inst == null){
			inst = new FichaOdontologica(p);
		}
		return inst;
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
		setBounds(100, 100, 641, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarFicha();
			}
		});
		btnGuardar.setBounds(10, 227, 89, 23);
		getContentPane().add(btnGuardar);
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
