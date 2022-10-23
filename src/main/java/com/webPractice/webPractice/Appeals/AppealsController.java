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

    private final AnswerRepository answerRepo;

    @Autowired
    public AppealsController(AppealsRepository appealsRepo,
                             UserRepository userRepo,
                             AnswerRepository answerRepo) {
        this.appealsRepo = appealsRepo;
        this.userRepo = userRepo;
        this.answerRepo = answerRepo;
    }

    @GetMapping
    public List<Appeals> getAllAppeals(){
        return appealsRepo.findAll();
    }

    @GetMapping("/{userId}")
    public List<Appeals> getAllAppealsUser(@PathVariable("userId") Integer userId){
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        return user.getAppealsList();
    }

    @PostMapping("/add{userId}")
    public void addQuestion(@PathVariable("userId") Integer userId, @RequestBody Appeals appeals){
        Optional<Appeals> appealsOptional =
                appealsRepo.findByText(appeals.getText());
        if (appealsOptional.isPresent()){
            throw new IllegalStateException("text is taken");
        }
        User user = userRepo.findById(userId).orElseThrow(()->
                new IllegalStateException("user not found"));
        String name = user.getName()+" "+user.getSurname();
        appeals.setName(name);
        User admin = userRepo.findById(1).orElseThrow(()->
                new IllegalStateException("admin not found"));
        appeals.setOpponent(admin.getName()+" "+admin.getSurname());
        user.addAppeal(appeals);
        appealsRepo.save(appeals);
    }

    @PostMapping("/answer")
    public String answerToAppeal(@RequestBody Answer answer) {
        Optional<Appeals> appealsOptional = appealsRepo.findById(answer.getAppealId());
        if (appealsOptional.isEmpty())
            throw new IllegalStateException("appeal not found");
        answerRepo.save(answer);
        return answer.getText();
    }

    @GetMapping("/answers{appealId}")
    public Answer getAllAnswers(@PathVariable("appealId") Integer appealId){
        return answerRepo.findByAppealId(appealId);
    }
}

