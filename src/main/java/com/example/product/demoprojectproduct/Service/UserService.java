package com.example.product.demoprojectproduct.Service;


import com.example.product.demoprojectproduct.Model.User;
import com.example.product.demoprojectproduct.Repository.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        logger.info("Fetching user with id:{}", userId);
        return userRepository.findById(userId).orElse(null);
    }

    public User addUser(@Valid User user) {
        user.setCreatedTime(LocalDateTime.now());
        logger.info("add new user:{}", user.getEmailId());

        return userRepository.save(user);
    }

    public User updateUser(String userId, User user) {
        logger.info("Update the user with id;{}", userId);
        user.setUserId(userId);
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        logger.info("Deleting user with id: {}", userId);
        userRepository.deleteById(userId);
    }


}
