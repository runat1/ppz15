package org.example;


import org.example.dao.UserDaoHibernateImpl;


public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userService=new UserDaoHibernateImpl();
        userService.createUsersTable();
        userService.saveUser("Dodo", "Piza", (byte)15);
        userService.saveUser("Mak", "Dac", (byte)4);
        userService.saveUser("Dilivery", "Clab", (byte)8);
        userService.saveUser("Piza", "Mia", (byte)30);
        System.out.println(userService.getAllUsers().toString());
        userService.cleanUsersTable();
        userService.dropUsersTable();
}

}