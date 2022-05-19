package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserDAO {
    public List<User> getAllUsers();
    public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException;
    public User createUser(User user);
    public ResponseEntity<User> updateUser(Long userId, User userDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException;
}
