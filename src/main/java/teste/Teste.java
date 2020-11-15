package teste;


import java.util.ArrayList;
import java.util.List;

import DAO.DepositoDAO;

import DAO.FilialDAO;
import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import controller.Compra;
import controller.DepositoController;
import controller.FuncionarioController;
import controller.ProdutoController;
import models.Deposito;

import models.Filial;
import models.Funcionario;
import models.Produto;
import models.ProdutoPerecivel;
import models.ProdutoRisco;

public class Teste {

	public static void main(String[] args) {
//
//		Deposito d = new Deposito("Merces", "Brigadeiro Franco", "Normal");

		DepositoDAO dedao = new DepositoDAO();

//		dedao.salvarDeposito(d);
		Deposito d = dedao.getDeposito(1);
//
//		DepositoController dc = new DepositoController();
//
//		System.out.println(d.getId());
//		
//		boolean v = dc.verificarDeposito(d.getId());
//		
//		System.out.println(v);
//
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

//		Funcionario f = funcionarioDAO.getFuncionario(0);
	
//		
		Funcionario f = new Funcionario(222, "Rafael", "não comprador");
////		
////		funcionarioDAO.salvarFuncionario(f);
////		
		FuncionarioController fc = new FuncionarioController();
		fc.cadastrarFuncionario(f);
//		boolean v = fc.verificarFuncionarioComprador(888);
//		
//		System.out.println(v);
		
//		DepositoController dc = new DepositoController();
//		boolean v = dc.verificarDeposito(10);
//		

//		
		
		
		
//		Produto p = new Produto("pepsi", 0, 100, 0);
//		
//		d.getProdutos().add(p);
//		
//		dedao.salvarDeposito(d);
		
//		Produto p = new Produto();
//		
//		ProdutoController pc = new ProdutoController();
//		pc.cadastrarProduto(p);
		
//		ProdutoDAO pdao = new ProdutoDAO();
//		p = pdao.getProduto(1);
//		
		
//		boolean v  = pc.inserirQuantidade(1, 20);
		
//		d.getProdutos().add(p);
//		
//		dedao.salvarDeposito(d);
		

		
		Compra c = new Compra();
		
		boolean v = c.executarCompra(100, 1, 2, 10);
		
		System.out.println(v);
	}

}


