package com.smitanshu.jobms.job;


import com.smitanshu.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll() {

        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping

    public ResponseEntity<String> createJob(@RequestBody Job job) {

        jobService.createJob(job);
        return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {

        JobDTO jobDTO = jobService.getJobById(id);

        if (jobDTO != null) {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {


        boolean deleted = jobService.deleteJobById(id);

        if (deleted) {

            return new ResponseEntity<>("Deleted Successfully!!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Job not found with id: " + id, HttpStatus.NOT_FOUND);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {

        boolean updated = jobService.updateJob(id, updatedJob);

        if (updated) {
            return new ResponseEntity<>("Updated Successfully!!", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
