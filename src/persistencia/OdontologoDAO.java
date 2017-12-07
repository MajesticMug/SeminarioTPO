package persistencia;

import java.util.List;

import modelo.Odontologo;
import utils.HibernateUtil;

public class OdontologoDAO {

	private static OdontologoDAO instancia;

	public static OdontologoDAO getInstancia() {
		if (instancia == null)
			instancia = new OdontologoDAO();
		return instancia;
	}

	public List<Odontologo> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from Odontologo").list();
	}
	
	

}
