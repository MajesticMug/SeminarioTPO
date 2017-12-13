package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import controlador.Sistema;
import modelo.PuntosMarcados;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerFichaOdontologica {

	private JFrame frame;
	private Image background;
	private modelo.FichaOdontologica ficha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modelo.FichaOdontologica ficha = Sistema.getInstance().getFichasOdontologicas().get(2);
					VerFichaOdontologica window = new VerFichaOdontologica(ficha);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public VerFichaOdontologica(modelo.FichaOdontologica ficha) throws IOException {
		this.ficha = ficha;
		initialize();
		background = ImageIO.read(new File("src/resources/img/FormularioDental.jpg"));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame() {
			@Override
			public void paint(java.awt.Graphics g) {
				super.paint(g);

				g.drawImage(background, 0, 20, this);
				
				PuntosMarcados puntos = ficha.getPuntosMarcados();
				
				g.setColor(Color.red);
				for (int i = 0; i < puntos.getPuntosX().size(); i++) {
					int x = puntos.getPuntosX().get(i);
					int y = puntos.getPuntosY().get(i);

					g.fillOval(x - 5, y - 5, 10, 10);
				}
			};
		};
		frame.setBounds(100, 100, 641, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVolver.setBounds(536, 238, 89, 23);
		frame.getContentPane().add(btnVolver);
	}
}
