package com.jobApp.JobApp.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob(@RequestBody Job job){
        jobService.createJob(job);
        return(new ResponseEntity<String>("Job added successfully" , HttpStatus.OK));
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job !=null) {
            return new ResponseEntity<Job>(job, HttpStatus.OK);
        }
        Job A = new Job(1L, "TestJob" , "test Description" , "2000", "3000", "India");
        return new ResponseEntity<Job>(A , HttpStatus.NOT_FOUND);
    }
}
