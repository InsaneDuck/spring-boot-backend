package dev.insaneduck.springbootbackend.batch.employee;


import dev.insaneduck.springbootbackend.entities.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class EmployeeBatchConfiguration {

    /**
     * returns Job objected to be injected into Job in BatchController
     * @return returns Job
     */
    @Bean
    public Job importEmployeeJob(JobRepository jobRepository,
                                 EmployeeJobExecutionListener listener, Step step1) {
        return new JobBuilder("importEmployeeJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    /**
     * for injecting bean for creating the job
     * @return returns step
     */
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      EmployeeItemReader employeeFlatFileItemReader,
                      EmployeeItemProcessor employeeItemProcessor,
                      EmployeeItemWriter employeeItemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee> chunk(10, transactionManager)
                .reader(employeeFlatFileItemReader)
                .processor(employeeItemProcessor)
                .writer(employeeItemWriter)
                .build();
    }

}

