package com.Gestion_Note.Note.Services;

import com.Gestion_Note.Note.Entities.User;
import com.Gestion_Note.Note.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User user) throws Exception {
        User existingUser = userRepo.findById(user.getUserId());
        if (existingUser == null) {
             userRepo.save(user);
        } else {
            throw new Exception("User already exists with ID: " + user.getUserId());
        }
    }

    public void deleteUser(int UserId) throws Exception {
        User existingUser = userRepo.findById(UserId);
        if (existingUser != null) {
            userRepo.delete(existingUser);
        } else {
            throw new Exception("No User Found with ID: " + UserId);
        }
    }

    public User getUser(int UserId) throws Exception {
        User userExist = userRepo.findById(UserId);
        if (userExist != null) {
            return userExist;
        } else {
            throw new Exception("User Not Found with ID: " + UserId);
        }
    }

    public void updateUser(User user) throws Exception {
        User existingUser = userRepo.findById(user.getUserId());
        if (existingUser != null) {
            existingUser.setName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            existingUser.setNationality(user.getNationality());
            userRepo.save(existingUser);
        } else {
            throw new Exception("User Not Found with ID: " + user.getUserId());
        }
    }
}
