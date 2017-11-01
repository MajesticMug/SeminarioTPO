package test;

import modelo.Paciente;
import modelo.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest
{

	public static void main(String[] args)
	{
		
		Paciente paciente = new Paciente("OSDE", 123, "Javier", "Capello", "DNI", 1000000, "Calle falsa 123",
				123123, 'm', new java.sql.Date(0, 0, 0), "PAC");
		
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Usuario.class)
				.addAnnotatedClass(Paciente.class);
		
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(paciente);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
