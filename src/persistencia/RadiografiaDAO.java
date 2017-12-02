package persistencia;

import org.hibernate.Session;

import utils.HibernateUtil;
import modelo.Radiografia;

public class RadiografiaDAO
{
	public void guardar(Radiografia rad) {
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
