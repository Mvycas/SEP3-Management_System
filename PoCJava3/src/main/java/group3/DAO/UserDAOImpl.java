package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.User;
import group3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import java.util.List;


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
    public User getUserById(Long userId) throws ResourceNotFoundException
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with this id" + userId));
        return user;
    }

    @Override
    public User createUser(User user)
    {
        return this.userRepository.save(user); //returns entity with id
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId, User user) throws ResourceNotFoundException
    {
        User userToUpdate = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with this id" + user.getId()));

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getUsername());
        userToUpdate.setPhoneNumber(user.getUsername());
        userToUpdate.setEmail(user.getUsername());
        userToUpdate.setPassword(user.getUsername());


        return ResponseEntity.ok(userRepository.save(userToUpdate));
    }

    @Override
    public ResponseEntity<User> deleteUser(Long userId) throws ResourceNotFoundException
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found with this id" + userId));
        this.userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
