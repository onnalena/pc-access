package com.example.pcaccess.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGDataSource {

    public static Connection dataSource() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5050/computer_lab", "postgres", "password");
    }

}
