package br.com.caelum.produtos.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.produtos.modelo.Usuario;
import br.com.caelum.produtos.util.HibernateUtil;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class UsuarioDAO {

	private Session session;

	public UsuarioDAO() {
		this.session = new HibernateUtil().getSession();
	}

	public Usuario buscaUsuarioPorLoginESenha(Usuario u) {
		Query query = this.session.createQuery("From Usuario where login = :pLogin and senha = :pSenha");
		query.setParameter("pLogin", u.getLogin());
		query.setParameter("pSenha", u.getSenha());
		return (Usuario) query.uniqueResult();
	}

}
