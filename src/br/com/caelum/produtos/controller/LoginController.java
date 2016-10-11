package br.com.caelum.produtos.controller;

import br.com.caelum.produtos.component.UsuarioLogado;
import br.com.caelum.produtos.dao.UsuarioDAO;
import br.com.caelum.produtos.modelo.Usuario;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {

	private UsuarioDAO usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;

	public LoginController(UsuarioDAO usuarioDao, UsuarioLogado usuarioLogado,
			Result result) {
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}

	public void autentica(Usuario usuario) {
		Usuario autenticado = usuarioDao.buscaUsuarioPorLoginESenha(usuario);
		if (autenticado != null) {
			
			usuarioLogado.efetuaLogin(autenticado);
			result.redirectTo(ProdutoController.class).lista();
			System.out.println("Direcionamento para produtocontroller");
			return;
			
		}
		result.redirectTo(LoginController.class).formulario();

	}

	public void formulario() {
	}

}

