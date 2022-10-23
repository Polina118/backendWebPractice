package com.webPractice.webPractice.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/schedule")
@CrossOrigin()
public class ScheduleController {

    private final ScheduleRepository scheduleRepo;
    private final SubjectRepository subjectRepo;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepo, SubjectRepository subjectRepo) {
        this.scheduleRepo = scheduleRepo;
        this.subjectRepo = subjectRepo;
    }

    @GetMapping("/{groupName}")
    public List<Schedule> getScheduleGroup(@PathVariable("groupName") String groupName){
        return scheduleRepo.findAllByGroupName(groupName);
    }

    @GetMapping("/teacher/{teacher}")
    public List<Schedule> getScheduleTeacher(@PathVariable("teacher") String teacher){
        return scheduleRepo.findAllByTeacher(teacher);
//        List<Schedule> schedules = new ArrayList<>();
//        for (Subject subject : subjects)
//            schedules.add(scheduleRepo.findBySubject(subject));
//        return scheduleRepo.findAllBySubjects(subjects);
    }

    @GetMapping()
    public List<Schedule> getScheduleAll(){
        return scheduleRepo.findAll();
    }

    @PostMapping("/add")
    public void addSchedule(@RequestBody Schedule schedule){
        for (Subject subject : schedule.getSubjects()) {
            String teacher = subject.getTeacher().split(" ")[0];
            schedule.setTeacher(teacher);
        }
        subjectRepo.saveAll(schedule.getSubjects());
        scheduleRepo.save(schedule);
    }
}
