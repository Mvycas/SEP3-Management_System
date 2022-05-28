package group3.controllers;

import group3.model.Employee;
import group3.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

public interface IEmployeeController {
    public Employee createEmployee(Employee employee) throws IOException, InterruptedException, ClassNotFoundException;
    public List<Employee> getAllEmployees() throws IOException, ClassNotFoundException;
    public Employee deleteEmployee(Long employeeId) throws IOException, ClassNotFoundException;
}
