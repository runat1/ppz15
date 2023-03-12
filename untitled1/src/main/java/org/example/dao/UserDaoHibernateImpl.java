package org.example.dao;

import org.example.model.User;
import org.example.util.Util;
import org.hibernate.Session;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user(id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR(30) NOT NULL,lastName VARCHAR(30) NOT NULL, age INTEGER, PRIMARY KEY (id))").addEntity(User.class).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error создание таблицы прошло неудачно");
            throw e;
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user").addEntity(User.class).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error удаление таблицы прошло неудачно");
            throw e;
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
           User user=new User(name,lastName,age);
           session.save(user);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {
            System.out.println("Error сохранение данных в таблицу прошло неудачно");
            throw e;
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE User WHERE id=" + id).executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println("Error удаление данных по id: "+id+", прошло неудачно");
            throw e;
        }

    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getConHibernate().openSession()) {
            return   session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            System.out.println("Error получение List<> для последующего использования прошло неудачно");
            throw e;
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getConHibernate().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println("Error очитка таблицы от данных прошла неудачно");
            throw e;
        }
    }
}
