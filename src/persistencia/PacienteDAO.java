package persistencia;

import java.util.List;

import modelo.Paciente;
import utils.HibernateUtil;

public class PacienteDAO {
	
	private static PacienteDAO instancia;

	public static PacienteDAO getInstancia() {
		if (instancia == null)
			instancia = new PacienteDAO();
		return instancia;
	}
	
	public List<Paciente> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from Paciente").list();
	}

	public void save(Paciente p) {
		HibernateUtil.guardarEntidad(p);
	}
	
	public void update(Paciente p) {
		HibernateUtil.actualizarEntidad(p);
	}
	
	public void remove(Paciente p) {
		HibernateUtil.eliminarEntidad(p);
	}
}
