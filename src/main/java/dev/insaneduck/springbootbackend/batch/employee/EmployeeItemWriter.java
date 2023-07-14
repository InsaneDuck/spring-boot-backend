package dev.insaneduck.springbootbackend.batch.employee;


import dev.insaneduck.springbootbackend.entities.Employee;
import dev.insaneduck.springbootbackend.repository.EmployeeRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

@Component
public class EmployeeItemWriter implements ItemWriter<Employee> {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeItemWriter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void write(@NonNull Chunk<? extends Employee> chunk) throws Exception {
        employeeRepository.saveAll(chunk);
    }
}
