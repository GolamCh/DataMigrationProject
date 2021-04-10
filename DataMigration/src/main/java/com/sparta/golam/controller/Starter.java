package com.sparta.golam.controller;

import com.sparta.golam.model.EmployeesDAO;
import com.sparta.golam.view.Printer;

public class Starter {

    public static void start() {

        //Printer.print(EmployeeList.createEmployeeArray()[1].getID());

        //EmployeesDAO.updateTable();

        /*EmployeeList.quarterArrays();
        Printer.print(EmployeeList.employeesq1.length);
        Printer.print(EmployeeList.employeesq2.length);
        Printer.print(EmployeeList.employeesq3.length);
        Printer.print(EmployeeList.employeesq4.length);
        Printer.print(EmployeeList.employeesq3[3].getID());
        Printer.print(EmployeeList.employeesq4[16].getID());*/

        //EmployeesDAO.Concurrent();

        EmployeesDAO.customConcurrent(10);



    }

}
