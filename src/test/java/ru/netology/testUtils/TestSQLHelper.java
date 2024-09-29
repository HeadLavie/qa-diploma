package ru.netology.testUtils;

import lombok.AccessLevel;
import lombok.Getter;

import java.sql.*;

public class TestSQLHelper {

//    private static String dbUrl = System.getProperty("db.url"); //для запуска из консоли
//    private static String dbUser = System.getProperty("db.user");
//    private static String dbPass = System.getProperty("db.pass");

//    private static final String dbUrl = "jdbc:postgresql://127.0.0.1:5432/app"; //для запуска из Idea
    private static final String dbUrl = "jdbc:mysql://185.119.57.164:3306/app"; //для запуска из Idea
    private static final String dbUser = "app";
    private static final String dbPass = "pass";

    public static String getPayTable() {
        return payTable;
    }

    public static String getCreditTable() {
        return creditTable;
    }

    @Getter(AccessLevel.NONE)
    private static String payTable = "payment_entity";

    @Getter(AccessLevel.NONE)
    private static String creditTable = "credit_request_entity";

    public static void setPayTable(String payTable) {
        TestSQLHelper.payTable = payTable;
    }

    public static void setCreditTable(String creditTable) {
        TestSQLHelper.creditTable = creditTable;
    }

    public static void cleanTables() throws SQLException {
        String cleanCreditTables = "DELETE FROM credit_request_entity;";
        String cleanOrderTable = "DELETE FROM order_entity;";
        String cleanPaymentTable = "DELETE FROM payment_entity;";
        Connection c = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        Statement s = c.createStatement();
        s.executeUpdate(cleanCreditTables);
        s.executeUpdate(cleanOrderTable);
        s.executeUpdate(cleanPaymentTable);
        c.close();
    }

    public static String getOperationStatus(String table) {
        String status = "";
        try (Connection c = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement s = c.createStatement()) {
            try (ResultSet resultSet = s.executeQuery("SELECT * FROM " + table + " ORDER BY id DESC LIMIT 1;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return status;
    }

}