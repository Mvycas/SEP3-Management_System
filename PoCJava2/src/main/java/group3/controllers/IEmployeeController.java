package group3.controllers;

import group3.model.Employee;

import java.io.IOException;

public interface IEmployeeController {
    public Employee createEmployee(Employee employee) throws IOException, InterruptedException, ClassNotFoundException;
}
