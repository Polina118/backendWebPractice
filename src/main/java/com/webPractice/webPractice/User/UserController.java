package com.webPractice.webPractice.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin()
public class UserController {

    private final UserRepository userRepo;

//    private final String uploadPath =
//            "C://Users//ISerg//IdeaProjects//backendWebPractice1//src//main//resources//img";

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

    @PutMapping("/icon{userId}")
    @Transactional
    public String addFile(@RequestParam("filename") String filename, @PathVariable("userId") Integer userId) {
        if (filename == null || filename.length() == 0)
            throw new IllegalStateException("file not found");
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        user.setIcon(filename);
        return filename;
    }

    @DeleteMapping("/icon{userId}")
    @Transactional
    public String deleteFile(@PathVariable("userId") Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        user.setIcon("https://avatars.mds.yandex.net/i?id=30ba25c368001a59a73785c51f2bbfcd-4907872-images-thumbs&n=13");
        return user.getIcon();
    }

    @PutMapping("/{userId}")
    @Transactional
    public void about(@RequestParam String about, @PathVariable("userId") Integer userId){
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        user.setAbout(about);
    }


}
