package com.smitanshu.jobms.job.impl;

import com.smitanshu.jobms.job.Job;
import com.smitanshu.jobms.job.JobRepository;
import com.smitanshu.jobms.job.JobService;
import com.smitanshu.jobms.job.clients.CompanyClient;
import com.smitanshu.jobms.job.clients.ReviewClient;
import com.smitanshu.jobms.job.dto.JobDTO;
import com.smitanshu.jobms.job.external.Company;
import com.smitanshu.jobms.job.external.Review;
import com.smitanshu.jobms.job.mapper.JobMapper;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class JobServiceImpl implements JobService {


    @Autowired
    RestTemplate restTemplate;


    private final JobRepository jobRepository;
    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    int attempt = 0;


    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }


    @Override
    //@CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyBreakerFallBack")
    // @Retry(name = "companyBreaker", fallbackMethod = "companyBreakerFallBack")
    @RateLimiter(name = "companyBreaker")
    public List<JobDTO> findAll() {
        System.out.println("Attempt:" + ++attempt);
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    public List<String> companyBreakerFallBack(Exception e) {
        List<String> list = new ArrayList<>();
        list.add("dummy");
        return list;
    }


    private JobDTO convertToDTO(Job job) {
        //Using Feign Client :
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReview(job.getCompanyId());
        JobDTO jobDTO = JobMapper.mapTojobWithCompanyDTO(job, company, reviews);
        return jobDTO;

    }


    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {

        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);

    }

    @Override
    public boolean deleteJobById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setDescription(updatedJob.getDescription());
            job.setTitle(updatedJob.getTitle());
            job.setLocation(updatedJob.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}



