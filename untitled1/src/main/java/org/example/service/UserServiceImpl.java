//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.service;



import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;

import java.util.List;


public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoHibernateImpl();
    UserDaoHibernateImpl userDaoJDBC= new UserDaoHibernateImpl();

    public UserServiceImpl() {
        this.userDaoJDBC = (UserDaoHibernateImpl) this.userDao;
    }

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        this.userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        this.userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return this.userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        this.userDaoJDBC.cleanUsersTable();
    }
}
