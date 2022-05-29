package group3.controllers;

import group3.InitializeConnection;
import group3.model.Employee;
import group3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    InitializeConnection initializeConnection;


    //save employee
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) throws IOException, ClassNotFoundException { //Request Body Deserializes

        System.out.println("Posting...");
        Employee newEmployee = (Employee) initializeConnection.sendTransferObject("post", employee); //should check this in another place maybe instead
        System.out.println(newEmployee.getUsername());
        return newEmployee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws IOException, ClassNotFoundException {
        System.out.println("Getting All employees");
        Employee employee = new Employee();
        return (List<Employee>) initializeConnection.sendTransferObject("allEmployees", employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long employeeId) throws IOException, ClassNotFoundException {
        System.out.println("Deleting...");
        return (Employee) initializeConnection.sendTransferObject("deleteEmployee", new Employee(employeeId));
    }
}
