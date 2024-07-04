package hpe.forage.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class InitializeEmployeesData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    public InitializeEmployeesData(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        Path path = Path.of("src/main/resources/data/employees.json");
        try {
            byte[] jsonData = Files.readAllBytes(path);
            Employee[] employees = objectMapper.readValue(jsonData, Employee[].class);
            employeeRepository.saveAll(List.of(employees));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
