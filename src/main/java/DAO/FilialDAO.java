package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Deposito;
import models.Filial;
import util.HibernateUtil;

public class FilialDAO {

	public void salvarFilial(Filial filial) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Salvar objetp
			session.saveOrUpdate(filial);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public void removerFilial(long id) {
		Transaction trans = null;
		Filial filial= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
					
			//Selecionar o  objetp
			filial = session.get(Filial.class, id);
			session.remove(filial);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		} 
	}
	
	public Filial getFilial(long id) {
		Transaction trans = null;
		Filial filial = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Iniciar transação
			trans = session.beginTransaction();
			
			//Selecionar o  objetp
			filial= session.get(Filial.class, id);
			
			//Confimar transação (comit)
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
		return filial;
	}
	
	public List<Filial> getFiliais() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Filial", Filial.class).list();
		}
	}
}
