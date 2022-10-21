package com.webPractice.webPractice.Appeals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users/appeals")
@CrossOrigin()
public class AppealsController {
    private final AppealsRepository appealsRepo;

    @Autowired
    public AppealsController(AppealsRepository appealsRepo) {
        this.appealsRepo = appealsRepo;
    }

    @GetMapping
    public List<Appeals> getAllAnswers(){
        return appealsRepo.findAll();
    }

    @PostMapping("/add")
    public void addAnswer(@RequestBody Appeals appeals){
        Optional<Appeals> appealsOptional =
                appealsRepo.findByText(appeals.getText());
        if (appealsOptional.isPresent()){
            throw new IllegalStateException("text is taken");
        }
        appealsRepo.save(appeals);
    }
}

