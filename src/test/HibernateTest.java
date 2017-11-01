package test;

import modelo.Odontologo;
import modelo.Paciente;
import modelo.Radiologo;
import modelo.Secretaria;
import modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{

	public static void main(String[] args)
	{
		
		Paciente paciente = new Paciente("OSDE", 123, "Javier", "Capello", "DNI", 1000000, "Calle falsa 123",
				123123, 'm', new java.sql.Date(0, 0, 0), "PAC");
		
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Usuario.class)
				.addAnnotatedClass(Paciente.class)
				.addAnnotatedClass(Odontologo.class)
				.addAnnotatedClass(Radiologo.class)
				.addAnnotatedClass(Secretaria.class);
		
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(paciente);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
