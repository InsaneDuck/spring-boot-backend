package dev.insaneduck.springbootbackend.batch.employee;


import dev.insaneduck.springbootbackend.entities.Employee;
import dev.insaneduck.springbootbackend.repository.EmployeeRepository;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeJobExecutionListener implements JobExecutionListener {
    private final JdbcTemplate jdbcTemplate;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeJobExecutionListener(EmployeeRepository employeeRepository,
                                        JdbcTemplate jdbcTemplate) {
        this.employeeRepository = employeeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            employeeRepository.findAll().forEach(System.out::println);

            //can delete uploaded csv file from cache folder if needed
        }
    }
}
