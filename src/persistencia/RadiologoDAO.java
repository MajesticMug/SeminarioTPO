package persistencia;

import java.util.List;

import modelo.Radiologo;
import utils.HibernateUtil;

public class RadiologoDAO {

	private static RadiologoDAO instancia;
	
	public static RadiologoDAO getInstancia() {
		if (instancia == null)
			instancia = new RadiologoDAO();
		return instancia;
	}

	public List<Radiologo> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from Radiologo").list();
	}

}
