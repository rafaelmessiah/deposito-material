package controller;

import DAO.ProdutoDAO;
import models.Produto;

public class ProdutoController {

	public Produto salvarProduto(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produtoDAO.salvarProduto(produto);
			return produto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Produto verificarProdutoDeposito(long idProduto, long idDeposito) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			Produto produto = produtoDAO.getProduto(idProduto);
			if (produto != null) {
				if (produto.getDeposito().getId() == idDeposito) {
					return produto;
				} else {
					return null;
				}

			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Verifica se o produto está no deposito, que ja foi verificado previamente
		return null;
	}

	public Produto verificarQuantidadeInserida(Produto produto, int qtdeInserida) {
		//Verifica se pode ser inserida a quantidade e retorna um produto com a quantidade ja inserida, mas sem ainda salvar no banco
		if (produto.getQuantidadeArmazenada() + qtdeInserida <= produto.getQuantidadeMaxima()) {
			produto.setQuantidadeArmazenada(produto.getQuantidadeArmazenada() + qtdeInserida);
			return produto;
		} else {
			return null;
		}

	}
	
}
