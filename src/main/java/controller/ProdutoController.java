package controller;

import DAO.ProdutoDAO;
import models.Deposito;
import models.Produto;

public class ProdutoController {

	public Produto cadastrarProduto(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produtoDAO.salvarProduto(produto);
			return produto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public boolean verificarProdutoDeposito(long idProduto, long idDeposito) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			Produto produto = produtoDAO.getProduto(idProduto);
			if(produto!=null) {
				if(produto.getDeposito().getId()==idDeposito) {
					return true;
				}else {
					return false;
				}

			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//Verifica se o produto está no deposito, que ja foi verificado previamente
		return false;
	}

	public boolean inserirQuantidade(long IdProduto, int qtdeInserida) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.getProduto(IdProduto);
		if(produto.getQuantidadeArmazenada()+qtdeInserida<=produto.getQuantidadeMaxima()) {
			produto.setQuantidadeArmazenada(produto.getQuantidadeArmazenada()+qtdeInserida);
			produtoDAO.salvarProduto(produto);
			return true;
		}else {
			return false;
		}
		
	}
}
