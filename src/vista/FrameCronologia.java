package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FrameCronologia extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton abonos;
	private JButton personal;
	private JButton convenios;
	private JLabel Administracion;
    private static FrameCronologia inst=null;
    
    /**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameCronologia inst = new FrameCronologia();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private FrameCronologia() {
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
	public static FrameCronologia getInstance(){
		if(inst == null){
			inst = new FrameCronologia();
		}
		return inst;
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
