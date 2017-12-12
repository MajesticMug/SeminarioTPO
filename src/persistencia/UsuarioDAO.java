package persistencia;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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

}
