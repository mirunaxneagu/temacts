package ro.ase.acs.sql.classes;

import ro.ase.acs.sql.interfaces.InterfaceCreateTble;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTble implements InterfaceCreateTble {


    @Override
    public void createTable(Connection connection) throws SQLException {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlDrop);
        statement.executeUpdate(sqlCreate);
        statement.close();
        connection.commit();
    }
}