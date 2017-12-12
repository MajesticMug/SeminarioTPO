package test;

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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{

	public static void main(String[] args)
	{
		
		Paciente paciente = new Paciente("OSDE", 123, "Javier", "Capello", "DNI", 1000000, "Calle falsa 123",
				123123, 'm', new java.sql.Date(0, 0, 0), "PAC","jcapello","jcapello");
		
		Secretaria secretaria = new Secretaria("Juana", "De Arco", "DNI", 123456, "Calle falsa 321", 456456, 'f',
				new java.sql.Date(0, 0, 0), "SEC","jdecarco","jdearco");
		
		PuntosMarcados puntos = new PuntosMarcados();
		List<Integer> aux = new ArrayList<Integer>();
		List<Integer> aux2 = new ArrayList<Integer>();
		for (Integer i=0;i<10;i++) {
			aux.add(i);
		}
		puntos.setPuntosX(aux);
		
		for (Integer i=0;i<10;i++) {
			aux2.add(i);
		}
		puntos.setPuntosY(aux2);
		
		Configuration con = new Configuration().configure()
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
		
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(paciente);
		
		session.save(puntos);
		
		session.save(secretaria);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
