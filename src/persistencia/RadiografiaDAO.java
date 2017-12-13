package persistencia;

import java.util.List;

import org.hibernate.Session;

import utils.HibernateUtil;
import modelo.Paciente;
import modelo.Radiografia;

public class RadiografiaDAO
{
	private static RadiografiaDAO instancia;

	public static RadiografiaDAO getInstancia() {
		if (instancia == null)
			instancia = new RadiografiaDAO();
		return instancia;
	}
	
	public List<Radiografia> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from Radiografia").list();
	}
	
	public void save(Radiografia rad) {
		HibernateUtil.guardarEntidad(rad);
	}
	
	public Radiografia buscar(int id)
	{
		Radiografia res = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		res = (Radiografia) session.get(Radiografia.class, id);
		
		session.close();
		
		return res;
	}
}
