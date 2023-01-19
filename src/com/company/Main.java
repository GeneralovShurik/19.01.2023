package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Class.forName() - вызывает все блоки static
        // внутри приведенного класса
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.100.101:3306/test",
                "admin", "12345"
        );

        UsersRepository up = new UsersRepository(conn);

        Server s = new Server();
        s.start();

       /* up.getAll().stream().forEach(System.out::println);

        User u = new User();
        u.setName("Igor");
        u.setBday("2012-01-02 10:11:12");
        u.setAge(20);
        up.addUser(u);

        System.out.println(up.avgAge("2000-01-03"));*/
    }

}
