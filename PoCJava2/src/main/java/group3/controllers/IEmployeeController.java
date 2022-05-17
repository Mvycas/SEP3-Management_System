package group3.controllers;

import group3.model.Employee;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IEmployeeController
{

    public List<Employee> getAllEmployees() throws IOException, ClassNotFoundException;
    public ResponseEntity<Employee> getEmployeeById(Long employeeId);
    public Employee createEmployee(Employee employee) throws IOException, InterruptedException, ClassNotFoundException;
    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails);
    public Map<String, Boolean> deleteEmployee(Long employeeId);

}
