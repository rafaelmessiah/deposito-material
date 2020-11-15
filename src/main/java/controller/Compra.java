package controller;

import models.Deposito;
import models.Funcionario;
import models.NotaFiscal;
import models.Produto;

public class Compra {

	public boolean executarCompra(long cpfFuncionario, long idDeposito, long idProduto, int qtdeInserida) {
		//Verificar Se o funcionario é comprador
		FuncionarioController funcionarioController = new FuncionarioController();
		if(funcionarioController.verificarFuncionarioComprador(cpfFuncionario)) {
			//Verificar se o deposito existe
			DepositoController depositoController = new DepositoController();
			if(depositoController.verificarDeposito(idDeposito)) {
				//Verificar se o Produto está cadastrado no deposito
				ProdutoController produtoController = new ProdutoController();
				if(produtoController.verificarProdutoDeposito(idProduto, idDeposito)) {
					//Tenta Inserir quantidade no produto
					if(produtoController.inserirQuantidade(idProduto, qtdeInserida)) {
						//Gera Nota Fiscal
						return true;
					}
				}
			}
		}

		return false;
	}

}

