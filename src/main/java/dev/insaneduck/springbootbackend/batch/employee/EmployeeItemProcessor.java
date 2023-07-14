package dev.insaneduck.springbootbackend.batch.employee;

import dev.insaneduck.springbootbackend.entities.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee,Employee> {

    public EmployeeItemProcessor() {
    }

    @Override
    public Employee process(@NonNull Employee employee) throws Exception {
        //custom filters if needed
        return employee;
    }
}
