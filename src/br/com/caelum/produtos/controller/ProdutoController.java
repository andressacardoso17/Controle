package br.com.caelum.produtos.controller;

import java.util.List;

import br.com.caelum.produtos.dao.ProdutoDAO;
import br.com.caelum.produtos.modelo.Produto;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProdutoController {

	private Result result;
	private ProdutoDAO dao;
	
	public ProdutoController(Result result, ProdutoDAO dao){
		this.result = result;
		this.dao = dao;
	}
	
	public ProdutoController(){
	}
	
	public List<Produto> lista() {
		return dao.lista();
	}

	public void adiciona(Produto produto){
		dao.adiciona(produto);
	}
	

	public void remove(Produto produto){
		dao.remove(produto);
		
	}
	
	public Produto edita(Long id){
		return dao.carrega(id);
	}

	public void altera(Produto produto) {
		dao.atualiza(produto);
		result.redirectTo(ProdutoController.class).lista();
	}

	
	public void formulario() {
	}
}
