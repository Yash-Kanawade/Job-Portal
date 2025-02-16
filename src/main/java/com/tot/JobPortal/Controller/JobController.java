package com.tot.JobPortal.Controller;

import com.tot.JobPortal.Service.JobService;
import com.tot.JobPortal.module.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("/getjob")
    public List<Job> getJob(){
        return service.getJob();
    }
    @PostMapping("/addjob")
    public ResponseEntity<?> addJob(@RequestBody Job job){
        boolean flag = service.addJob(job);
        if(flag)
            return new ResponseEntity<>(job, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updatejob/{id}")
    public ResponseEntity<?> updateJob(@RequestBody Job job){
        Boolean flag = service.updateJob(job,job.getId());
        if(flag)
            return new ResponseEntity<>(job, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deletejob/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id){
        Boolean flag = service.deleteJob(id);
        if(flag){
            return new ResponseEntity<>("Job Deleted",HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>("Deletion failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchjob/{id}")
    public ResponseEntity<Job> searchJob(@PathVariable int id){
        Job job = service.searchJob(id);
        if(job != null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
