package com.example.jobListing.job.implement;

import com.example.jobListing.job.Job;
import com.example.jobListing.job.JobRepository;
import com.example.jobListing.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImplement implements JobService {

    JobRepository jobRepository;

    public JobServiceImplement(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
      try{
          jobRepository.deleteById(id);
          return true;
      } catch (Exception e){
          return false;
      }
    }

    


}
