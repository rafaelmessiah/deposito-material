package controller;

import DAO.ProdutoDAO;
import models.Deposito;
import models.Produto;

public class Movimento {

	public void adicionarProduto(Deposito deposito, Produto produto, int quantidadeInserida) {//Ira verificar se é possivel inserir determinado produto
//		//Verifica se o produto ja está registrado no deposito
//		ProdutoDAO produtodao = new ProdutoDAO();
//		
//		//Verifica se o nome do produto ja existe
//		if (produtodao.getProduto(produto.getCodigo())==null) {
//			produtodao.salvarProduto(produto);
//		}
		
		if(produto.getQuantidadeArmazenada()+quantidadeInserida<=produto.getQuantidadeMaxima()) {
			
			//Soma a quantidade nova
			produto.setQuantidadeArmazenada(produto.getQuantidadeArmazenada()+quantidadeInserida);
			
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			produtoDao.salvarProduto(produto);
		}else {
			System.out.println("Parado ai meu jovem, vc acaba de fazer algo ilegal");
		}
		
		
	}
	
	
}
