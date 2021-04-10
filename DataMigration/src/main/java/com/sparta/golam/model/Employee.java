package com.sparta.golam.model;

import java.time.LocalDate;

public class Employee {

    int ID, salary;
    String namePrefix, firstName, middleInitial, lastName, gender, email;
    LocalDate dateOfBirth, dateOfJoin;

    public Employee(int ID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoin, int salary) {
        this.ID = ID;
        this.namePrefix = namePrefix;
        this.salary = salary;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
    }

    public int getID() {
        return ID;
    }

    public int getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public String getNamePrefix() {
        return namePrefix;
    }
}
