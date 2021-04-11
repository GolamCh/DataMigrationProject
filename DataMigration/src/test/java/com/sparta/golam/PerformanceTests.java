package com.sparta.golam;

import com.sparta.golam.model.EmployeeList;
import com.sparta.golam.model.EmployeesDAO;
import com.sparta.golam.view.Printer;
import org.junit.Test;

public class PerformanceTests {

    int totalRows = EmployeeList.dataSetSize;

    /*@Test
    public void timingSingleThread() {
        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();
        EmployeesDAO.updateTable();
        Printer.line();
    }*/

    @Test
    public void timingQuadThread() {
        int rowCount = 0;
        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();
        final long start = System.currentTimeMillis();
        EmployeesDAO.fourThreadConcurrent();
        while (rowCount < totalRows) {
            rowCount = EmployeesDAO.countRows();
        }
        final long end = System.currentTimeMillis();
        final long total = end - start;
        Printer.print("Time take with 4 threads: " + total + "ms");
        Printer.line();
    }

    @Test
    public void timing10Thread() {
        int rowCount = 0;
        int numberOfThreads = 10;
        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();
        final long start = System.currentTimeMillis();
        EmployeesDAO.customConcurrent(numberOfThreads);
        while (rowCount < totalRows) {
            rowCount = EmployeesDAO.countRows();
        }
        final long end = System.currentTimeMillis();
        final long total = end - start;
        Printer.print("Time taken with " + numberOfThreads + " threads: " + total + "ms");
        Printer.line();
    }

    @Test
    public void timing4Thread() {
        int rowCount = 0;
        int numberOfThreads = 4;
        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();
        final long start = System.currentTimeMillis();
        EmployeesDAO.customConcurrent(numberOfThreads);
        while (rowCount < totalRows) {
            rowCount = EmployeesDAO.countRows();
        }
        final long end = System.currentTimeMillis();
        final long total = end - start;
        Printer.print("Time taken with " + numberOfThreads + " threads (method 2): " + total + "ms");
        Printer.line();
    }

    @Test
    public void timing20Thread() {
        int rowCount = 0;
        int numberOfThreads = 20;
        EmployeesDAO.dropTable();
        EmployeesDAO.createTable();
        final long start = System.currentTimeMillis();
        EmployeesDAO.customConcurrent(numberOfThreads);
        while (rowCount < totalRows) {
            rowCount = EmployeesDAO.countRows();
        }
        final long end = System.currentTimeMillis();
        final long total = end - start;
        Printer.print("Time taken with " + numberOfThreads + " threads: " + total + "ms");
        Printer.line();
    }
}
