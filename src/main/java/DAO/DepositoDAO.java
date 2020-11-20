package DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import models.Deposito;
import util.HibernateUtil;

public class DepositoDAO {

	public void salvarDeposito(Deposito deposito) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transa��o
			trans = session.beginTransaction();

			// Salvar objetp
			session.saveOrUpdate(deposito);

			// Confimar transa��o (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

	}

	public void removerDeposito(long id) {
		Transaction trans = null;
		Deposito deposito = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transa��o
			trans = session.beginTransaction();

			// Selecionar o objetp
			deposito = session.get(Deposito.class, id);
			session.remove(deposito);

			// Confimar transa��o (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
	}

	public Deposito getDeposito(long id) {
		Transaction trans = null;
		Deposito deposito = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transa��o
			trans = session.beginTransaction();

			// Selecionar o objetp
			deposito = session.get(Deposito.class, id);

			// Confimar transa��o (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

		return deposito;
	}

	public List<Deposito> getDepositos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Deposito", Deposito.class).list();
		}
	}

}
