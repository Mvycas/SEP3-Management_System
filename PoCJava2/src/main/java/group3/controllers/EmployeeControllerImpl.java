package group3.controllers;

import group3.InitializeConnection;
import group3.model.Employee;
import group3.validation.IValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    InitializeConnection initializeConnection;

    @Autowired
    IValidateUser validateUser;


    //get employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws IOException, ClassNotFoundException {
        System.out.println("Getting All");
        Employee employee = new Employee(99999, "default", "default");
        List<Employee> allEmployees = (List<Employee>) initializeConnection.getReceivedObject("all", employee);
        return allEmployees;
    }


    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
//        Employee employee = EmployeeValidationImpl;
//        return ResponseEntity.ok().body(employee);
        return null;
    }

    //save employee
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) throws IOException, InterruptedException, ClassNotFoundException { //Request Body Deserializes

        System.out.println("Posting...");
        Employee newemployee = (Employee) initializeConnection.getReceivedObject("post", employee); //should check this in another place maybe instead
        System.out.println(newemployee.getUsername());
        //System.out.println("Sent object employee: " + employee.getId() + " " + employee.getLogin() + " " + employee.getPassword());
        return newemployee;
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee employeeDetails) {

//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));
//
//        employee.setLogin(employeeDetails.getLogin());
//        employee.setPassword(employeeDetails.getPassword());
//
//        return ResponseEntity.ok(this.employeeRepository.save(employee));

        return null;
    }

    //delete employee
    @DeleteMapping("employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));
//
//        this.employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("delete", Boolean.TRUE);
//
//        return response;
        return null;
    }

    @PostMapping("check_employee")
    public boolean checkEmployee(@RequestBody Employee employee) throws IOException, ClassNotFoundException
    {
        if (validateUser.validateUser(employee))
        {
            System.out.println("Returning true from API");
            return true;
        }
        else
        {
            System.out.println("Returning false from API");
            return false;
        }
    }
}
