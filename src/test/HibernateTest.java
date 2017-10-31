package test;

import modelo.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{

	public static void main(String[] args)
	{
		Usuario usuario = new Usuario("Javier", "Capello", "DNI", 1000000, "Calle falsa 123",
							123123, 'm', new java.sql.Date(0, 0, 0), "PAC");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(usuario);
		
		session.getTransaction().commit();
	}

}
