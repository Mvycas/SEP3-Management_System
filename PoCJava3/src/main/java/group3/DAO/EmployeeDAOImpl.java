package group3.DAO;

import group3.model.Employee;
import group3.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeDAOImpl implements IEmployeeDAO{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
