package com.sparta.golam.model;

import com.sparta.golam.model.EmployeeList;
import com.sparta.golam.model.EmployeesDAO;

public class TaskTwo implements Runnable{
    @Override
    public void run() {
        EmployeesDAO.updateTableConcurrent(EmployeeList.employeesq2);
    }
}
