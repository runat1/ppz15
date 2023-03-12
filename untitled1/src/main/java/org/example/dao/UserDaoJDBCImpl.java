//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.dao;


import org.example.model.User;
import org.example.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement statement = Util.getCon().createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user(id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR(30) NOT NULL,lastName VARCHAR(30) NOT NULL, age INTEGER, PRIMARY KEY (id))");
        } catch (SQLException e) {
            System.out.println("Error создание таблицы прошло неудачно");
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getCon().createStatement()) {
            statement.executeUpdate("DROP table IF EXISTS user");
        } catch (SQLException e) {
            System.out.println("Error удаление таблицы прошло неудачно");
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = Util.getCon().createStatement()) {
            statement.execute("INSERT INTO user (name, lastName, age) value('" + name + "', '" + lastName + "', " + age + ")");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("Error сохранение данных в таблицу прошло неудачно");
            throw new RuntimeException(e);
        }

    }
    public void removeUserById(long id) {
        try (Statement statement = Util.getCon().createStatement()) {
            statement.executeUpdate("DELETE FROM user WHERE id=" + id);
        } catch (SQLException e) {
            System.out.println("Error удаление данных по id: "+id+", прошло неудачно");
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        try(Statement statement = Util.getCon().createStatement();) {
            ResultSet resultSet = statement.executeQuery("select * from user");
            while(resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3), (byte)resultSet.getInt("age"));
                users.add(user);
            }

            return users;
        }  catch (SQLException e) {
            System.out.println("Error получение List<> для последующего использования прошло неудачно");
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getCon().createStatement()) {
            statement.executeUpdate("DELETE FROM user ");
        } catch (SQLException e) {
            System.out.println("Error очитка таблицы от данных прошла неудачно");
            throw new RuntimeException(e);
        }
    }
}
