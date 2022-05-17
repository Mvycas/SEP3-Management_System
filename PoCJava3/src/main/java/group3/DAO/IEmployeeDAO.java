package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
    public List<Employee> getAllEmployees();
    public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException;
    public Employee createEmployee(Employee employee);
    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
