package persistencia;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import modelo.Odontologo;
import modelo.Paciente;
import modelo.Radiologo;
import modelo.Usuario;
import utils.HibernateUtil;

public class UsuarioDAO {
	
	private static UsuarioDAO instancia;
	private static SessionFactory sf;
	
	public static UsuarioDAO getInstancia() {
		if (instancia == null)
			instancia = new UsuarioDAO();
		sf=HibernateUtil.getSessionFactory();
		return instancia;
	}
	
	// VALIDAR USUARIO
	public boolean validarUsuario (String usuario, String contrasenia) {
		Session s=sf.openSession();
		Query q=s.createQuery("FROM Usuario WHERE usuario=?");
		q.setParameter(0, usuario);
		Usuario user;
		user = (Usuario) q.uniqueResult();
		if (user!=null) {
			if (user.getContrasenia().equals(contrasenia)) {
				return true;
			}
			else 
				return false;
		}
		else {
			return false;
		}
	}
	
	// RECUPERAR PACIENTES
	public List<Paciente> recuperarPacientes(){
		Session s=sf.openSession();
		Query q = s.createQuery("FROM Usuario where funcion=?").setString(0, "PAC");
		List<Paciente> pacientes = q.list();
		return pacientes;
	}
	
	// RECUPERAR PROFESIONALES
	public List<Radiologo> recuperarRadiologos(){
		Session s=sf.openSession();
		Query q = s.createQuery("FROM Usuario where funcion=?").setString(0, "RAD");
		List<Radiologo> radiologos = q.list();
		return radiologos;
	}
	
	public List<Odontologo> recuperarOdonotologos(){
		Session s=sf.openSession();
		Query q = s.createQuery("FROM Usuario where funcion=?").setString(0, "ODO");
		List<Odontologo> odontologos = q.list();
		return odontologos;
	}

}
