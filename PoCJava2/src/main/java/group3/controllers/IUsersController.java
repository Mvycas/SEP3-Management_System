package group3.controllers;

import group3.model.Employee;
import group3.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IUsersController
{

    public List<User> getAllUsers() throws IOException, ClassNotFoundException;
    public User getUserById(Long userId) throws ClassNotFoundException, IOException;
    public User createUser(User user) throws IOException, InterruptedException, ClassNotFoundException;
    public User updateUser(Long userId, User user) throws IOException, ClassNotFoundException;
    public User deleteUser(Long userId) throws IOException, ClassNotFoundException;
    public String checkUserAuthState(User user) throws IOException, ClassNotFoundException;
    public boolean checkIfUserExists(User user) throws IOException, ClassNotFoundException;
}
