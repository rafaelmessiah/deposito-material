package controller;



import models.Deposito;
import models.Funcionario;
import models.NotaFiscal;
import models.Produto;

public class Compra {

	public boolean executarCompra(long cpfFuncionario, long idDeposito, long idProduto, int qtdeInserida,String fornecedor) {

		//Chama todos os controller para executar a verificação	

		// Verificar Se o funcionario é comprador
		Funcionario funcionario = new Funcionario();
		FuncionarioController funcionarioController = new FuncionarioController();
		funcionario = funcionarioController.verificarFuncionarioComprador(cpfFuncionario);


		if (funcionario!=null) {

			// Verificar se o deposito existe
			Deposito deposito = new Deposito();
			DepositoController depositoController = new DepositoController();
			deposito = depositoController.verificarDeposito(idDeposito);

			if (deposito!=null) {

				// Verificar se o Produto está cadastrado no deposito
				Produto produto = new Produto();
				ProdutoController produtoController = new ProdutoController();
				produto = produtoController.verificarProdutoDeposito(idProduto, idDeposito);


				if (produto!=null) {

					//Tenta adicionar quantidade no produto, mas ainda sem salvar no banco
					produto = produtoController.verificarQuantidadeInserida(produto, qtdeInserida);

					if (produto!=null) {
						//Monta a NotaFiscal
						NotaFiscalController notaFiscalController = new NotaFiscalController();
						NotaFiscal notaFiscal = notaFiscalController.gerarNotaFiscal(funcionario, qtdeInserida, produto, fornecedor);

						if(notaFiscal!=null) {

							//Salvar Nota fiscal e Inserir Quantidade
							if(notaFiscalController.salvarNotaFiscal(notaFiscal)){
								//Só Salva o produto se conseguir salvar a nota antes
								produtoController.salvarProduto(produto);
								return true;
							}
							
							return false;
						}

						return false;
					}

					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}

}


