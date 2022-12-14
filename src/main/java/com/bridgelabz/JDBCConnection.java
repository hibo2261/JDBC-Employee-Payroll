package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;




public class JDBCConnection {
   static Connection connection;
    public static void main(String[] args) {
        connectToDatabase();
        driversList();
        try {
            readEmployeePayrollData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void connectToDatabase() {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "admin";
        try {
            System.out.println("\n Connecting to database : " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println(" Connection is Successful : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readEmployeePayrollData()  throws SQLException {
        PreparedStatement preparedStatement = JDBCConnection.connection.prepareStatement("select * from employee_payroll");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("\n ***********");
            System.out.println("\n EmployeeID   : " + resultSet.getString("id"));
            System.out.println(" EmployeeName : " + resultSet.getString("name"));
            System.out.println(" Address      : " + resultSet.getString("address"));
            System.out.println(" PhoneNumber  : " + resultSet.getString("phone_number"));
            System.out.println(" Department   : " + resultSet.getString("department"));
            System.out.println(" Gender       : " + resultSet.getString("gender"));
            System.out.println(" StartDate    : " + resultSet.getString("StartDate"));
            System.out.println(" BasicPay     : " + resultSet.getString("basic_pay"));
            System.out.println(" Deductions   : " + resultSet.getString("Deductions"));
            System.out.println(" TaxablePay   : " + resultSet.getString("Taxable_Pay"));
            System.out.println(" IncomeTax    : " + resultSet.getString("Tax"));
            System.out.println(" NetPay       : " + resultSet.getString("Net_Pay"));
        }
        System.out.println("\n ***********");
    }







    public static void driversList() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        System.out.println("\n List of drivers :");
        while ((driverList.hasMoreElements())) {
            Driver driver = (Driver) driverList.nextElement();
            System.out.println(" " + driver.getClass().getName());
        }
    }
}