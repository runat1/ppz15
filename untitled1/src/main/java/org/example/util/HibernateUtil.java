package org.example.util;

import org.example.dao.UserDaoHibernateImpl;
import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import javax.persistence.Query;
import java.sql.Statement;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

/*    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbtest?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "poot");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("подключено");
            } catch (Exception e) {
                System.out.println("ошибка при подключении");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }*/

    public static void main(String[] args) {
/*        Transaction transaction = null;
        try (Session session = Util.getConHibernate().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            User user=new User("Dodo", "Piza", (byte)15);
            session.save(user);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }*/
        //UserDaoJDBCImpl userDaoJDBC=new UserDaoJDBCImpl();
        //userDaoJDBC.saveUser("Mak", "Dac", (byte)4);

        //System.out.println(userDaoJDBC.getAllUsers().toString());
       try (Session session = Util.getConHibernate().openSession()) {
            long id =2;
            session.beginTransaction();
/*           User user=session.get(User.class,id);
            session.delete(user);*/
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        }
/*        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user(id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR(30) NOT NULL,lastName VARCHAR(30) NOT NULL, age INTEGER, PRIMARY KEY (id))").addEntity(User.class).executeUpdate();
        }*/
    }
}
