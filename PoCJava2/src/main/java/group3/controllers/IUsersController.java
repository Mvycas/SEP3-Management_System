package group3.controllers;

import group3.model.Employee;
import group3.model.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IUsersController
{

    public List<User> getAllUsers() throws IOException, ClassNotFoundException;
    public ResponseEntity<User> getUserById(Long userId);
    public User createUser(User user) throws IOException, InterruptedException, ClassNotFoundException;
    public ResponseEntity<User> updateUser(Long userId, User userDetails);
    public Map<String, Boolean> deleteUser(Long userId);
    public String checkUserAuthState(User user) throws IOException, ClassNotFoundException;
    public boolean checkIfUserExists(User user) throws IOException, ClassNotFoundException;
}
