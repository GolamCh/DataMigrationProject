package com.sparta.golam.model;

public class SQLQueries {

    public final String createTable = "CREATE TABLE employees ("
            + "employeeID INT PRIMARY KEY," +
            "name_prefix VARCHAR(5)," +
            "first_Name VARCHAR(10)," +
            "middle_initial CHAR," +
            "last_name VARCHAR(10)," +
            "gender CHAR," +
            "email VARCHAR(50)," +
            "date_of_birth DATE," +
            "date_of_joining DATE," +
            "salary INT);";

    /*public final String updateUsingParameters = "INSERT INTO employees (" +
            "employeeID," +
            "name_prefix," +
            "first_name," +
            "middle_initial," +
            "last_name," +
            "gender," +
            "email," +
            "date_of_birth," +
            "date_of_joining," +
            "salary" +
            ") " +
            "VALUES " +
            "(" +
            "?,?,?,?,?,?,?,?,?,?);";*/

    public final String updateUsingParameters = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?);";

}
