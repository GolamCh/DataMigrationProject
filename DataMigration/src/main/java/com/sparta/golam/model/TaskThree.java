package com.sparta.golam.model;

import com.sparta.golam.model.EmployeeList;
import com.sparta.golam.model.EmployeesDAO;

public class TaskThree implements Runnable{
    @Override
    public void run() {
        EmployeesDAO.updateTableConcurrent(EmployeeList.employeesq3);
    }
}
