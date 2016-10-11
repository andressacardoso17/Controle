package br.com.caelum.produtos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.produtos.modelo.Produto;
import br.com.caelum.produtos.util.HibernateUtil;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class ProdutoDAO {

	private Session session;

	public ProdutoDAO() {
		this.session = new HibernateUtil().getSession();
	}

	public void adiciona(Produto p) {
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}

	public void remove(Produto p) {
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return session.createCriteria(Produto.class).list();
	}

	public Produto carrega(long id) {
		return (Produto) this.session.load(Produto.class, id);
	}

	public void atualiza(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.update(produto);
		tx.commit();
	}

	public Produto pesquisa(Produto p) {
		Query query = this.session.createQuery("From Produto where id = :pId");
		query.setParameter("pId", p.getId());
		return (Produto) query.uniqueResult();
	}

}
