package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Deposito;
import models.Produto;
import util.HibernateUtil;

public class ProdutoDAO {

	public void salvarProduto(Produto produto) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Salvar objetp
			session.saveOrUpdate(produto);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public void removerProduto(long id) {
		Transaction trans = null;
		Produto produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
					
			//Selecionar o  objetp
			produto = session.get(Produto.class, id);
			session.remove(produto);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		} 
	}
	
	public Produto getProduto(long id) {
		Transaction trans = null;
		Produto produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Selecionar o  objetp
			produto = session.get(Produto.class, id);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
		return produto;
	}
	
//	public Produto getProdutoByDep(String nomeProduto, String nomeDeposito) {
//		Transaction trans = null;
//		Produto produto = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			//Iniciar transação
//			trans = session.beginTransaction();
//			
//			//Selecionar o  objetp
//			produto = session.get()
//			
//			//Confimar transação (comit)
//			trans.commit();
//			
//		} catch (Exception e) {
//			trans.rollback();
//		}
//		
//		return produto;
//	}
	
	public List<Produto> getProdutos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Produto", Produto.class).list();
		}
	}
}
