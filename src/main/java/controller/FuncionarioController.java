package controller;

import DAO.FuncionarioDAO;
import models.Funcionario;

public class FuncionarioController {

	public boolean verificarFuncionarioComprador(long cpf) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.getFuncionario(cpf);
		if(funcionario!=null) {//Verifica se o funcionario existe
			if(funcionario.getCargo().equalsIgnoreCase("comprador")) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			funcionarioDAO.salvarFuncionario(funcionario);
			return funcionario;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
		
	}
}
