package com.sparta.golam.model;

import com.sparta.golam.controller.DateFormatter;
import com.sparta.golam.controller.FilterIDs;
import com.sparta.golam.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeList {

    static ArrayList<String[]> startingData = FilterIDs.findOriginalIDs();
    static int dataSetSize = startingData.size();

    static Employee[] employeeArray = new Employee[dataSetSize];

    static Employee[] employeesq1;
    static Employee[] employeesq2;
    static Employee[] employeesq3;
    static Employee[] employeesq4;

    public static Employee[] createEmployeeArray() {
        for (int i = 0; i < dataSetSize; i++) {
            String[] data = startingData.get(i);
            int ID = Integer.parseInt(data[0]);
            int salary = Integer.parseInt(data[9]);
            LocalDate birth = DateFormatter.clean(data[7]);
            LocalDate join = DateFormatter.clean(data[8]);
            Employee employee = new Employee(ID, data[1], data[2], data[3], data[4], data[5], data[6], birth, join, salary);
            employeeArray[i] = employee;
        }
        return employeeArray;
    }

    public static void quarterArrays() {
        int dataQuarterSize = dataSetSize/4;
        int fourthArraySize = dataSetSize - (dataQuarterSize * 3);
        employeesq1 = new Employee[dataQuarterSize];
        employeesq2 = new Employee[dataQuarterSize];
        employeesq3 = new Employee[dataQuarterSize];
        employeesq4 = new Employee[fourthArraySize];
        for (int i = 0; i < dataSetSize; i++) {
            String[] data = startingData.get(i);
            int ID = Integer.parseInt(data[0]);
            int salary = Integer.parseInt(data[9]);
            LocalDate birth = DateFormatter.clean(data[7]);
            LocalDate join = DateFormatter.clean(data[8]);
            Employee employee = new Employee(ID, data[1], data[2], data[3], data[4], data[5], data[6], birth, join, salary);
            if (i < dataQuarterSize) {
                employeesq1[i] = employee;
            } else if (i < (dataQuarterSize * 2)) {
                employeesq2[i - (dataQuarterSize)] = employee;
            } else if (i >= (dataQuarterSize * 2) && i < (dataQuarterSize * 3)) {
                employeesq3[i - (dataQuarterSize * 2)] = employee;
            } else {
                employeesq4[i - (dataQuarterSize * 3)] = employee;
            }
        }
    }

    public static Employee[] customArray(int numberOfThreads, int start) {
        int blockSize = dataSetSize/numberOfThreads;
        Employee[] employees = new Employee[blockSize];
        for (int i = start; i < (start+blockSize);i++) {
            String[] data = startingData.get(i);
            int ID = Integer.parseInt(data[0]);
            int salary = Integer.parseInt(data[9]);
            LocalDate birth = DateFormatter.clean(data[7]);
            LocalDate join = DateFormatter.clean(data[8]);
            Employee employee = new Employee(ID, data[1], data[2], data[3], data[4], data[5], data[6], birth, join, salary);
            employees[i - start] = employee;
        }
        return employees;
    }

    public static Employee[] leftOver(int numberOfThreads) {
        int blockSize = dataSetSize/numberOfThreads;
        int leftOverSize = dataSetSize - (blockSize*(numberOfThreads-1));
        Employee[] employees = new Employee[leftOverSize];
        int start = dataSetSize - leftOverSize;
        for (int i = start; i < dataSetSize; i++) {
            String[] data = startingData.get(i);
            int ID = Integer.parseInt(data[0]);
            int salary = Integer.parseInt(data[9]);
            LocalDate birth = DateFormatter.clean(data[7]);
            LocalDate join = DateFormatter.clean(data[8]);
            Employee employee = new Employee(ID, data[1], data[2], data[3], data[4], data[5], data[6], birth, join, salary);
            employees[i - start] = employee;
        }
        return employees;
    }

}
