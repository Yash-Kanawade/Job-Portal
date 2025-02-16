package com.tot.JobPortal.repo;

import com.tot.JobPortal.module.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job,Integer> {
}
