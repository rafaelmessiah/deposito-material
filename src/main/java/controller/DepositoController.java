package controller;

import DAO.DepositoDAO;
import models.Deposito;


public class DepositoController {

	public Deposito verificarDeposito(long id) {
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.getDeposito(id);

		if (deposito != null) {
			return deposito;
		} else {
			return null;
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
