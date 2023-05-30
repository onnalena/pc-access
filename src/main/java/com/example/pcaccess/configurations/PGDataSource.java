package com.example.pcaccess.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGDataSource {

    public static Connection dataSource() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://192.168.137.1:5432/computer-lab", "postgres", "safe");
    }

}
