package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import models.ProdutoRisco;
import util.HibernateUtil;

public class ProdutoRiscoDAO {

	public void salvarProduto(ProdutoRisco produto) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Salvar objetp
			session.saveOrUpdate(produto);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

	}

	public void removerProduto(long id) {
		Transaction trans = null;
		ProdutoRisco produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			produto = session.get(ProdutoRisco.class, id);
			session.remove(produto);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
	}

	public ProdutoRisco getProduto(long id) {
		Transaction trans = null;
		ProdutoRisco produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			produto = session.get(ProdutoRisco.class, id);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

		return produto;
	}

	public List<ProdutoRisco> getProdutos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from ProdutoRisco", ProdutoRisco.class).list();
		}
	}
}
