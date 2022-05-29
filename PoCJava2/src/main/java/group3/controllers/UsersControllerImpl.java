package group3.controllers;

import group3.InitializeConnection;
import group3.model.User;
import group3.validation.IValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public User getUserById(@PathVariable("id") Long userId) throws IOException, ClassNotFoundException {
        User user = new User();
        user = (User) initializeConnection.sendTransferObject("getUserById", new User(userId));
        return user;

    }

    //save user
    @PostMapping("users")
    public User createUser(@RequestBody User user) throws IOException, InterruptedException, ClassNotFoundException {

        System.out.println("Posting...");
        User newUser = (User) initializeConnection.sendTransferObject("post", user);
        System.out.println(newUser.getUsername());
        return newUser;
    }

    //update user
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user) throws IOException, ClassNotFoundException {

        System.out.println("Updating...");
        User newUser = (User) initializeConnection.sendTransferObject("update",
                new User(userId, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),
                        user.getEmail(), user.getPhoneNumber(), user.getAuthLevel()));
        return newUser;
    }

    //delete user
    @DeleteMapping("users/{id}")
    public User deleteUser(@PathVariable("id") Long userId) throws IOException, ClassNotFoundException {
        System.out.println("Deleting...");
        User user = (User) initializeConnection.sendTransferObject("delete", new User(userId));
        return user;
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
