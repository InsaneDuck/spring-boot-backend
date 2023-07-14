package dev.insaneduck.springbootbackend.batch.employee;

import dev.insaneduck.springbootbackend.entities.Employee;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class EmployeeItemReader
        extends FlatFileItemReader<Employee>
        implements StepExecutionListener {

    public EmployeeItemReader() {
        super();
        setName("employeeItemReader");
        setLinesToSkip(1);
        setStrict(false);
        setLineMapper(lineMapper());
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        JobParameters jobParameters = stepExecution.getJobParameters();
        String inputFile = jobParameters.getString("JobFile");
        FileSystemResource fileSystemResource = new FileSystemResource(inputFile);
        setResource(fileSystemResource);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    private LineMapper<Employee> lineMapper() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("firstName", "lastName");

        BeanWrapperFieldSetMapper<Employee> employeeBeanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        employeeBeanWrapperFieldSetMapper.setTargetType(Employee.class);


        DefaultLineMapper<Employee> employeeDefaultLineMapper = new DefaultLineMapper<>();
        employeeDefaultLineMapper.setLineTokenizer(lineTokenizer);
        employeeDefaultLineMapper.setFieldSetMapper(employeeBeanWrapperFieldSetMapper);

        return employeeDefaultLineMapper;
    }
}
