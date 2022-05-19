package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.User;
import group3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //Maybe
public class UserDAOImpl implements IUserDAO
{

    @Autowired
    private IUserRepository userRepository;

    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + userId));
        return ResponseEntity.ok().body(user);
    }

    @Override
    public User createUser(User user)
    {

        return this.userRepository.save(user); //returns entity with id
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId, User userDetails) throws ResourceNotFoundException
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + userId));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    @Override
    public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id" + userId));

        this.userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
}
