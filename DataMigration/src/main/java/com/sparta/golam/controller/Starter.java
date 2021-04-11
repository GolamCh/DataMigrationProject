package com.sparta.golam.controller;

import com.sparta.golam.model.EmployeesDAO;
import com.sparta.golam.view.Printer;

public class Starter {

    public static void start() {


        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();

        //EmployeesDAO.updateTable();
        EmployeesDAO.fourThreadConcurrent();
        //EmployeesDAO.customConcurrent(150);





    }

}
