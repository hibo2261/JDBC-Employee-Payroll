package com.bridgelabz;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeePayrollService {
    /**
     *  Method to get all employee payroll data
     */
    public void   readEmployeePayrollData() throws SQLException {
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
}
