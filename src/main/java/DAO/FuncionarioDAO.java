package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Deposito;
import models.Funcionario;
import util.HibernateUtil;

public class FuncionarioDAO {

	public void salvarFuncionario(Funcionario funcionario) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Salvar objetp
			session.saveOrUpdate(funcionario);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public void removerFuncionario(long id) {
		Transaction trans = null;
		Funcionario funcionario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
					
			//Selecionar o  objetp
			funcionario = session.get(Funcionario.class, id);
			session.remove(funcionario);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		} 
	}
	
	public Funcionario getFuncionario(long id) {
		Transaction trans = null;
		Funcionario funcionario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Selecionar o  objetp
			funcionario = session.get(Funcionario.class, id);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
		return funcionario;
	}
	
	public List<Funcionario> getFuncionarios() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Funcionario", Funcionario.class).list();
		}
	}
}
