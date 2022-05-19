package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Employee;
import group3.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //Maybe
public class EmployeeDAO implements IEmployeeDAO
{

    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees()
    {
        return this.employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException
    {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @Override
    public Employee createEmployee(Employee employee)
    {

        return this.employeeRepository.save(employee); //returns entity with id
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));

        employee.setUsername(employeeDetails.getUsername());
        employee.setPassword(employeeDetails.getPassword());

        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));

        this.employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
}
