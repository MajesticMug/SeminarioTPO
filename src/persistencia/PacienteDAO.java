package persistencia;

import java.util.List;

import org.hibernate.Session;

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

	public void save(Paciente p)
	{
		Session session = HibernateUtil.openSession();
		
		session.beginTransaction();
		
		session.save(p);
		
		session.getTransaction().commit();
		
		session.close();
	}

	public void update(Paciente p)
	{
		Session session = HibernateUtil.openSession();
		
		session.beginTransaction();
		
		session.update(p);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
}
