package com.webPractice.webPractice.Appeals;
import com.webPractice.webPractice.User.User;
import com.webPractice.webPractice.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users/appeals")
@CrossOrigin()
public class AppealsController {
    private final AppealsRepository appealsRepo;
    private final UserRepository userRepo;

    @Autowired
    public AppealsController(AppealsRepository appealsRepo,
                             UserRepository userRepo) {
        this.appealsRepo = appealsRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<Appeals> getAllAnswers(){
        return appealsRepo.findAll();
    }

    @PostMapping("/add{userId}")
    public void addAnswer(@PathVariable("userId") Integer userId, @RequestBody Appeals appeals){
        Optional<Appeals> appealsOptional =
                appealsRepo.findByText(appeals.getText());
        if (appealsOptional.isPresent()){
            throw new IllegalStateException("text is taken");
        }
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        String name = user.getName()+" "+user.getSurname();
        user.addAppeal(new Appeals(name, appeals.getText()));
    }
}

