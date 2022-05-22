package group3.controllers;

import group3.InitializeConnection;
import group3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    InitializeConnection initializeConnection;


    //save employee
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) throws IOException, InterruptedException, ClassNotFoundException { //Request Body Deserializes

        System.out.println("Posting...");
        Employee newEmployee = (Employee) initializeConnection.sendTransferObject("post", employee); //should check this in another place maybe instead
        System.out.println(newEmployee.getUsername());
        return newEmployee;
    }
}
