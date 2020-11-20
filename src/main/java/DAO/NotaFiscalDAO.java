package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Deposito;
import models.NotaFiscal;
import util.HibernateUtil;

public class NotaFiscalDAO {

	public void salvarNotaFiscal(NotaFiscal notaFiscal) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Salvar objetp
			session.saveOrUpdate(notaFiscal);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

	}

	public void removerNotaFiscal(long id) {
		Transaction trans = null;
		Deposito deposito = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			deposito = session.get(Deposito.class, id);
			session.remove(deposito);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
	}

	public NotaFiscal getNotaFiscal(long id) {
		Transaction trans = null;
		NotaFiscal notaFiscal = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar transação
			trans = session.beginTransaction();

			// Selecionar o objetp
			notaFiscal = session.get(NotaFiscal.class, id);

			// Confimar transação (comit)
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}

		return notaFiscal;
	}

	public List<NotaFiscal> getDepositos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from NotaFiscal", NotaFiscal.class).list();
		}
	}
}
