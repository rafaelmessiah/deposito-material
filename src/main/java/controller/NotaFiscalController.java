package controller;

import java.util.Calendar;


import DAO.NotaFiscalDAO;
import models.Funcionario;
import models.NotaFiscal;
import models.Produto;

public class NotaFiscalController {

	public NotaFiscal gerarNotaFiscal(Funcionario funcionario, int qtdeComprada, Produto produto, String fornecedor) {
		NotaFiscal notaFiscal = new NotaFiscal();
		
		notaFiscal.setQuantidadeComprada(qtdeComprada);
		
		//Valor da compra = custo do produto x quantidade comprada
		notaFiscal.setValorCompra(produto.getCusto()*qtdeComprada);
		
		notaFiscal.setFornecedor(fornecedor);
		
		//Pega a data do momento que vai gerar a compra
		notaFiscal.setDataCompra(Calendar.getInstance());
		
		notaFiscal.setFuncionario(funcionario);
		
		
		return notaFiscal;
	}
	
	public boolean salvarNotaFiscal(NotaFiscal notaFiscal) {
		NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();
		
		try {
			notaFiscalDAO.salvarNotaFiscal(notaFiscal);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
