package com.sparta.golam.model;

import com.sparta.golam.view.Printer;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class EmployeesDAO {

    static SQLQueries sqlQueries = new SQLQueries();

    private static final String URL = "jdbc:mysql://localhost:3306/data_migration?serverTimezone=GMT";

    private static Connection connection;

    private static Properties properties = new Properties();

    private static Connection connectToDatabase(){
        try {
            properties.load(new FileReader("resources/login.properties"));
            connection = DriverManager.getConnection(URL,properties.getProperty("username"),properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void createTable() {
        try {
            Statement statement = connectToDatabase().createStatement();
            statement.executeUpdate(sqlQueries.createTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Printer.print("The employees table has been created successfully");
    }

    public static int countRows() {
        Statement statement = null;

        try {
            statement = connectToDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueries.countRows);
            resultSet.next();
            return resultSet.getInt("COUNT(*)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public static void dropTable() {
        try {
            Statement statement = connectToDatabase().createStatement();
            statement.executeUpdate(sqlQueries.dropTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Printer.print("The employees table has been removed sucessfully");
    }

    public static void updateTable() {
        Employee[] employees = EmployeeList.createEmployeeArray();
        final long start = System.currentTimeMillis();
        int numEntries = employees.length;
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(sqlQueries.updateUsingParameters);
            for (int i = 0; i < numEntries; i++) {
                preparedStatement.setInt(1, employees[i].getID());
                preparedStatement.setString(2, employees[i].getNamePrefix());
                preparedStatement.setString(3, employees[i].getFirstName());
                preparedStatement.setString(4, employees[i].getMiddleInitial());
                preparedStatement.setString(5, employees[i].getLastName());
                preparedStatement.setString(6, employees[i].getGender());
                preparedStatement.setString(7, employees[i].getEmail());
                preparedStatement.setDate(8, Date.valueOf(employees[i].getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employees[i].getDateOfJoin()));
                preparedStatement.setInt(10, employees[i].getSalary());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        final long end = System.currentTimeMillis();
        final long total = end - start;
        Printer.print("Time taken to read, clean data, fill table: " + total + "ms");
    }

    public static void updateTableConcurrent(Employee[] employees) {
        int numEntries = employees.length;
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(sqlQueries.updateUsingParameters);
            for (int i = 0; i < numEntries; i++) {
                preparedStatement.setInt(1, employees[i].getID());
                preparedStatement.setString(2, employees[i].getNamePrefix());
                preparedStatement.setString(3, employees[i].getFirstName());
                preparedStatement.setString(4, employees[i].getMiddleInitial());
                preparedStatement.setString(5, employees[i].getLastName());
                preparedStatement.setString(6, employees[i].getGender());
                preparedStatement.setString(7, employees[i].getEmail());
                preparedStatement.setDate(8, Date.valueOf(employees[i].getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employees[i].getDateOfJoin()));
                preparedStatement.setInt(10, employees[i].getSalary());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void fourThreadConcurrent() {
        EmployeeList.quarterArrays();

        TaskOne taskOne = new TaskOne();
        TaskTwo taskTwo = new TaskTwo();
        TaskThree taskThree = new TaskThree();
        TaskFour taskFour = new TaskFour();

        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        Thread threadThree = new Thread(taskThree);
        Thread threadFour = new Thread(taskFour);

        threadOne.start();
        //Printer.print("Thread 1 has started...");
        threadTwo.start();
        //Printer.print("Thread 2 has started...");
        threadThree.start();
        //Printer.print("Thread 3 has started...");
        threadFour.start();
        //Printer.print("Thread 4 has started...");
    }


    public static void customConcurrent(int threads) {
        int start;
        start = 0;
        int incrementSize = EmployeeList.dataSetSize/threads;
        int x = 1;

        for (int i = 0; i < threads; i++) {
            if (i < threads - 1) {
                Employee[] employees = EmployeeList.customArray(threads, start);
                class Task implements Runnable {

                    @Override
                    public void run() {
                        updateTableConcurrent(employees);
                    }
                }
                Task task = new Task();
                Thread thread = new Thread(task);
                thread.start();
                //Printer.print("Thread " + x++ + " has started");

                start+=incrementSize;
            } else {
                Employee[] employees = EmployeeList.leftOver(threads);
                class Task implements Runnable {

                    @Override
                    public void run() {
                        updateTableConcurrent(employees);
                    }
                }
                Task task = new Task();
                Thread thread = new Thread(task);
                thread.start();
                //Printer.print("Thread " + x++ + " has started");
            }
        }
        try {
            connectToDatabase().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
