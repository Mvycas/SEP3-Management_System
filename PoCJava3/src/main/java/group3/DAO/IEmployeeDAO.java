package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeDAO {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public ResponseEntity<Employee> deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
