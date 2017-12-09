package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FrameInformacion extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton abonos;
	private JButton personal;
	private JButton convenios;
	private JLabel Administracion;
    private static FrameInformacion inst=null;
    
    /**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameInformacion inst = new FrameInformacion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private FrameInformacion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			
			
			pack();
			this.setSize(413, 341);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FrameInformacion getInstance(){
		if(inst == null){
			inst = new FrameInformacion();
		}
		return inst;
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
