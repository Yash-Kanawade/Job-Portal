package com.tot.JobPortal.Service;

import com.tot.JobPortal.module.Job;
import com.tot.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;


    public List<Job> getJob() {
        return repo.findAll();
    }

    public boolean addJob(Job job) {
        repo.save(job);
        return true;
    }

    public Boolean updateJob(Job job, int id) {
        Optional<Job> djob = repo.findById(id);
        if(djob.isPresent()){
            Job updatedjob = djob.get();
            updatedjob.setId(id);
            updatedjob.setName(job.getName());
            updatedjob.setDesignation(job.getDesignation());
            updatedjob.setDomain(job.getDomain());
            updatedjob.setSalary(job.getSalary());
            updatedjob.setExperience(job.getExperience());
            repo.save(updatedjob);
            return true;
        }
        return false;
    }

    public Boolean deleteJob(int id) {
        Optional<Job> job = repo.findById(id);
        if(job.isPresent())
        {
            repo.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public Job searchJob(int id) {
        Optional<Job> job = repo.findById(id);
        return job.orElse(null);
    }
}
