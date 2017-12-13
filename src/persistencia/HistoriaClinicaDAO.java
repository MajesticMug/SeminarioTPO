package persistencia;

import java.util.List;

import modelo.HistoriaClinica;
import modelo.Paciente;
import utils.HibernateUtil;

public class HistoriaClinicaDAO {
	
	private static HistoriaClinicaDAO instancia;
	
	public static HistoriaClinicaDAO getInstancia() {
		if (instancia == null)
			instancia = new HistoriaClinicaDAO();
		return instancia;
	}
	
	public List<HistoriaClinica> findAll() {
		return HibernateUtil.getSessionFactory().openSession().createQuery("from HistoriaClinica").list();
	}

	public void save(HistoriaClinica hc) {
		HibernateUtil.guardarEntidad(hc);
	}
	
	public void update(HistoriaClinica hc) {
		HibernateUtil.actualizarEntidad(hc);
	}
	
	public void remove(HistoriaClinica hc) {
		HibernateUtil.eliminarEntidad(hc);
	}

}
