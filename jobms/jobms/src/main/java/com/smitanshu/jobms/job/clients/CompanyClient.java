package com.smitanshu.jobms.job.clients;

import com.smitanshu.jobms.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {


    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);


}
