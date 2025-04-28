package com.Gestion_Note.Note.Controllers;


import com.Gestion_Note.Note.Entities.User;
import com.Gestion_Note.Note.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userservice.saveUser(user);
            return ResponseEntity.ok("User added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public User getUser(@RequestParam int id) {
        try {
            return userservice.getUser(id);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam int id) {
        try {
            userservice.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping ("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            userservice.updateUser(user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
