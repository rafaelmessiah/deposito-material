package teste;


import java.util.ArrayList;
import java.util.List;

import DAO.DepositoDAO;

import DAO.FilialDAO;
import DAO.ProdutoDAO;
import controller.Movimentar;
import models.Deposito;

import models.Filial;
import models.Produto;
import models.ProdutoPerecivel;
import models.ProdutoRisco;

public class Teste {

	public static void main(String[] args) {

		ProdutoDAO pedao = new ProdutoDAO();
		
		Produto p = pedao.getProduto(1);
		
	
		Movimentar mov = new Movimentar();
		
		mov.adicionarProduto(p, 49);
	}

}


