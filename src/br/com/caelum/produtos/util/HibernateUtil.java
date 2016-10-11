package br.com.caelum.produtos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.produtos.modelo.Produto;
import br.com.caelum.produtos.modelo.Usuario;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration().addAnnotatedClass(Produto.class).addAnnotatedClass(Usuario.class);
		factory = cfg.buildSessionFactory();
	}
	
	public Session getSession(){
		return factory.openSession();
	}

}
