package group3.DAO;

import group3.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
}
