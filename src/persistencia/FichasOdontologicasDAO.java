package persistencia;

import java.util.List;

import modelo.FichaOdontologica;
import utils.HibernateUtil;

public class FichasOdontologicasDAO {
	
	private static FichasOdontologicasDAO instancia;
	public static FichasOdontologicasDAO getInstancia() {
		if (instancia == null)
			instancia = new FichasOdontologicasDAO();
		return instancia;
	}
	
	public List<FichaOdontologica> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from FichaOdontologica").list();
	}

	

}
