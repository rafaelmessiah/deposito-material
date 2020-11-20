package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import models.ProdutoPerecivel;
import util.HibernateUtil;

public class ProdutoPerecivelDAO {

	public void salvarProduto(ProdutoPerecivel produto) {
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
		ProdutoPerecivel produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			produto = session.get(ProdutoPerecivel.class, id);
			session.remove(produto);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
	}

	public ProdutoPerecivel getProduto(long id) {
		Transaction trans = null;
		ProdutoPerecivel produto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			produto = session.get(ProdutoPerecivel.class, id);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

		return produto;
	}

	public List<ProdutoPerecivel> getProdutos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from ProdutoPerecivel", ProdutoPerecivel.class).list();
		}
	}
}
