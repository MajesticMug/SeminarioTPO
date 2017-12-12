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
		// CREACION DE PACIENTES
		Paciente paciente = new Paciente("OSDE", 123, "Javier", "Gonzalez", "DNI", 1000000, "Calle falsa 123", 123123, 'm', 
				new java.sql.Date(0, 0, 0), "PAC","jgonzalez","jgonzalez");
		Paciente paciente1 = new Paciente("Medicus", 123, "Lorena", "Martinez", "DNI", 1100100, "Fake Street 567", 123456, 'f',
				new java.sql.Date(0, 0, 0), "PAC","lmartinez","lmartinez");
		Paciente paciente2 = new Paciente("Swiss Medicals", 123, "Ximena", "Fernandez", "DNI", 1100230, "Independencia 1000", 
				123432, 'f', new java.sql.Date(0, 0, 0), "PAC","xfernandez","xfernandez");
		Paciente paciente3 = new Paciente("OSDE", 123, "Diego", "Perez", "DNI", 1052000, "Laprida 239", 123321, 'm', 
				new java.sql.Date(0, 0, 0), "PAC","dperez","dperez");
		Paciente paciente4 = new Paciente("OSECAC", 123, "Mauro", "Zapata", "DNI", 1000740, "Gaona 1335", 126789, 'm', 
				new java.sql.Date(0, 0, 0), "PAC","mzapata","mzapata");
		Paciente paciente5 = new Paciente("Medicus", 123, "Fernando", "Esquivel", "DNI", 1000123, "Armenia 1356", 129009, 'm',
				new java.sql.Date(0, 0, 0), "PAC","fesquivel","fesquivel");
		
		// CREACION DE SECRETARIA
		Secretaria secretaria = new Secretaria("Juana", "De Arco", "DNI", 123456, "Calle falsa 321", 456456, 'f',
				new java.sql.Date(0, 0, 0), "SEC","jdearco","jdearco");
		
		//CREACION DE RADIOLOGO
		Radiologo radiologo = new Radiologo(99231234, "Jose", "Gomez", "DNI", 7654321, "25 de Mayo 500", 123678, 'm', 
				new java.sql.Date(0, 0, 0), "RAD", "jgomez", "jgomez");
		
		//CREACION DE ODONTOLOGO
		Odontologo odontologo = new Odontologo(9800123, "Mariana", "Balboa", "DNI", 187653, "Ugarte 1123", 6554234, 'f', 
				new java.sql.Date(0, 0, 0), "ODO", "mbalboa", "mbalboa");
		
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
		session.save(paciente1);
		session.save(paciente2);
		session.save(paciente3);
		session.save(paciente4);
		session.save(paciente5);
		
		session.save(puntos);
		
		session.save(secretaria);
		
		session.save(radiologo);
		session.save(odontologo);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
