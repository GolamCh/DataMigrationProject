package com.sparta.golam.model;

public class SQLQueries {

    public final String createTable = "CREATE TABLE employees ("
            + "employeeID INT PRIMARY KEY," +
            "name_prefix VARCHAR(5)," +
            "first_Name VARCHAR(20)," +
            "middle_initial CHAR," +
            "last_name VARCHAR(20)," +
            "gender CHAR," +
            "email VARCHAR(50)," +
            "date_of_birth DATE," +
            "date_of_joining DATE," +
            "salary INT);";

    public final String updateUsingParameters = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?);";

    public final String countRows = "SELECT COUNT(*) FROM employees LIMIT 10000";

    public final String dropTable = "DROP TABLE employees";

}
