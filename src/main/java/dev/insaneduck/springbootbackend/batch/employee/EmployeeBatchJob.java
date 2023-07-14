package dev.insaneduck.springbootbackend.batch.employee;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.lang.NonNullApi;

public class EmployeeBatchJob implements Job {
    @Override
    public String getName() {
        return "importEmployeeJob";
    }

    @Override
    public void execute(JobExecution execution) {

    }


}
