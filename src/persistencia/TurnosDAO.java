package persistencia;

import java.util.List;

import modelo.Turno;
import utils.HibernateUtil;

public class TurnosDAO
{

	
	private static TurnosDAO instancia;

	public static TurnosDAO getInstancia() {
		if (instancia == null)
			instancia = new TurnosDAO();
		return instancia;
	}
	
	public List<Turno> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from Turno").list();
	}

	public void save(Turno t) {
		HibernateUtil.guardarEntidad(t);
	}
	
	public void update(Turno t) {
		HibernateUtil.actualizarEntidad(t);
	}
	
	public void remove(Turno t) {
		HibernateUtil.eliminarEntidad(t);
	}
}
