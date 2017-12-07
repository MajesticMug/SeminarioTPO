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
	
}
