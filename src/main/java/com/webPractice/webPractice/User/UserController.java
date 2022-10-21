package com.webPractice.webPractice.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin()
public class UserController {

    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        Optional<User> userOptional =
                userRepo.findByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email is taken");
        }
        userRepo.save(user);
        return "success";
    }

    @PostMapping("/autorization")
    public User autorization(@RequestBody LoginForm loginForm){
        User user = userRepo.findByEmail(loginForm.getEmail()).orElseThrow(()->
                new IllegalStateException("incorrect login"));
        if (!Objects.equals(user.getPassword(), loginForm.getPassword()))
            throw new IllegalStateException("incorrect password");
        return user;
    }
}
