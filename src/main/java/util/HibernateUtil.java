package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import models.Deposito;
import models.Filial;
import models.Funcionario;
import models.NotaFiscal;
import models.Produto;
import models.ProdutoPerecivel;
import models.ProdutoRisco;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

				settings.put(Environment.URL,
						"jdbc:mysql://localhost/deposito_material?createDatabaseIfNotExist=true&useSSL=false&user=root&password=");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				// Classes
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Deposito.class);
				configuration.addAnnotatedClass(Filial.class);
				configuration.addAnnotatedClass(Funcionario.class);
				configuration.addAnnotatedClass(NotaFiscal.class);
				configuration.addAnnotatedClass(ProdutoPerecivel.class);
				configuration.addAnnotatedClass(ProdutoRisco.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
