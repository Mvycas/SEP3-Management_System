package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Employee;
import group3.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeDAOImpl implements IEmployeeDAO{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> deleteEmployee(Long employeeId) throws ResourceNotFoundException
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee was not found with this id" + employeeId));
        this.employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
