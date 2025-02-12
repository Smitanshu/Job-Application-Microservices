package com.smitanshu.jobms.job.mapper;

import com.smitanshu.jobms.job.Job;
import com.smitanshu.jobms.job.dto.JobDTO;
import com.smitanshu.jobms.job.external.Company;
import com.smitanshu.jobms.job.external.Review;

import java.util.List;


public class JobMapper {
    public static JobDTO mapTojobWithCompanyDTO(Job job, Company company, List<Review> reviews) {

        JobDTO jobDTO = new JobDTO();

        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);


        return jobDTO;
    }
}
