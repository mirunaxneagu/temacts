package ro.ase.acs.sql;

import ro.ase.acs.sql.classes.CreateTble;
import ro.ase.acs.sql.classes.InsertData;
import ro.ase.acs.sql.classes.ReaderData;
import ro.ase.acs.sql.interfaces.InterfaceCreateTble;
import ro.ase.acs.sql.interfaces.InterfaceInsertData;
import ro.ase.acs.sql.interfaces.InterfaceReaderData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String  CONEXIUNE = "jdbc:sqlite:database.db";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONEXIUNE);
            connection.setAutoCommit(false);

            InterfaceCreateTble tableCreator =  new CreateTble();
            tableCreator.createTable(connection);

            InterfaceInsertData dataInserter =  new InsertData();
            dataInserter.insertData(connection);

            InterfaceReaderData dataReader =  new ReaderData();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}