package controller;

import DAO.DepositoDAO;
import models.Deposito;
import models.Produto;

public class DepositoController {

	public boolean verificarDeposito(long id) {
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.getDeposito(id);
		
		if (deposito!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public Deposito cadastrarDeposito(Deposito deposito) {
		DepositoDAO depositoDAO = new DepositoDAO();
		try {
			depositoDAO.salvarDeposito(deposito);
			return deposito;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	
	
	}
	
	
}
