package group3.controllers;

import group3.InitializeConnection;
import group3.model.User;
import group3.validation.IValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsersControllerImpl implements IUsersController {

    @Autowired
    InitializeConnection initializeConnection;

    @Autowired
    IValidateUser validateUser;


    //get users
    @GetMapping("/users")
    public List<User> getAllUsers() throws IOException, ClassNotFoundException {
        System.out.println("Getting All");
        User user = new User();
        List<User> allUsers = (List<User>) initializeConnection.sendTransferObject("all", user);
        return allUsers;
    }


    //get user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
//        Employee employee = EmployeeValidationImpl;
//        return ResponseEntity.ok().body(employee);
        return null;
    }

    //save user
    @PostMapping("users")
    public User createUser(@RequestBody User user) throws IOException, InterruptedException, ClassNotFoundException { //Request Body Deserializes

        System.out.println("Posting...");
        User newUser = (User) initializeConnection.sendTransferObject("post", user); //should check this in another place maybe instead
        System.out.println(newUser.getUsername());
        //System.out.println("Sent object employee: " + employee.getId() + " " + employee.getLogin() + " " + employee.getPassword());
        return newUser;
    }

    //update user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {

//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + employeeId));
//
//        employee.setLogin(employeeDetails.getLogin());
//        employee.setPassword(employeeDetails.getPassword());
//
//        return ResponseEntity.ok(this.employeeRepository.save(employee));

        return null;
    }

    //delete user
    @DeleteMapping("users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) {
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

    @PostMapping("user_exists")
    public boolean checkIfUserExists(@RequestBody User user) throws IOException, ClassNotFoundException
    {
        if (validateUser.userExists(user))
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

    @PostMapping("user_auth")
    public String checkUserAuthState(@RequestBody User user) throws IOException, ClassNotFoundException
    {
        return validateUser.userAuthState(user);
    }

    @PostMapping("user")
    public User getUser(@RequestBody User user) throws IOException, ClassNotFoundException
    {
        return validateUser.userInfo(user);
    }
}
