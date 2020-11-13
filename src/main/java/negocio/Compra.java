package negocio;

import DAO.DepositoDAO;
import models.NotaFiscal;

public class Compra {
	
	
//	public void executarCompra(Deposito_Produto depositoProduto, NotaFiscal notaFiscal) {
//		
//		int quantidadeDisponivel = (depositoProduto.getQuantidadeMaxima()-depositoProduto.getQuantidadeArmazenada());
//		
//		if(notaFiscal.getQuantidadeComprada()<=quantidadeDisponivel) {//Verifica se a quantidade comprada é cabe no deposito
//			
//			//Atualiza a quantidade
//			depositoProduto.setQuantidadeArmazenada(depositoProduto.getQuantidadeArmazenada()+notaFiscal.getQuantidadeComprada());
//			
//			//Salva no Banco de dados
//			DepositoProdutoDAO dpDAO = new DepositoProdutoDAO();
//			try {
//				dpDAO.salvarDepositoProduto(depositoProduto);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
//	}
//	

}
