package persistencia;

import java.util.List;

import modelo.Odontologo;
import modelo.Paciente;
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

	public void save(Odontologo o) {
		HibernateUtil.guardarEntidad(o);
	}
	
	public void update(Odontologo o) {
		HibernateUtil.actualizarEntidad(o);
	}
	
	public void remove(Odontologo o) {
		HibernateUtil.eliminarEntidad(o);
	}

}
