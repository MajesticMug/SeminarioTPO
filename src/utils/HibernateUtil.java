package utils;

import modelo.ConsentimientoTratamiento;
import modelo.FichaOdontologica;
import modelo.HistoriaClinica;
import modelo.Odontologo;
import modelo.Paciente;
import modelo.PlanTratamiento;
import modelo.PuntosMarcados;
import modelo.Radiografia;
import modelo.Radiologo;
import modelo.Secretaria;
import modelo.Turno;
import modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author imssbora
 */
public class HibernateUtil {
  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;
  
  public static Configuration configuration;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
    	sessionFactory = getConfiguracion().buildSessionFactory();
    }
    return sessionFactory;
  }
  
  /*
   * Acà van los mapeos: agregas las entidades nuevas aca para que funcione
   */
  public static Configuration getConfiguracion() {
	  if (configuration == null) {
		  configuration = new Configuration().configure()
				.addAnnotatedClass(Usuario.class)
				.addAnnotatedClass(Paciente.class)
				.addAnnotatedClass(Odontologo.class)
				.addAnnotatedClass(Radiologo.class)
				.addAnnotatedClass(Secretaria.class)
				.addAnnotatedClass(FichaOdontologica.class)
				.addAnnotatedClass(PlanTratamiento.class)
				.addAnnotatedClass(ConsentimientoTratamiento.class)
				.addAnnotatedClass(Radiografia.class)
				.addAnnotatedClass(HistoriaClinica.class)
				.addAnnotatedClass(Turno.class)
				.addAnnotatedClass(PuntosMarcados.class);
	  }
	  
	  return configuration;
  }

  public static void shutdown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }
  
  public static void guardarEntidad(Object entidad) {
	  	Session session = getSessionFactory().openSession();
	  	
		session.beginTransaction();
	
		session.save(entidad);
		
		session.getTransaction().commit();
		
		session.close();
  }
}