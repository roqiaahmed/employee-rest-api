package hpe.forage.employees;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("")
    List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addNewEmplyee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateEmpolyee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> optionalEmpolyee = employeeRepository.findById(id);
        if (optionalEmpolyee.isPresent()) {
            Employee exEmployee = optionalEmpolyee.get();
            exEmployee.setFirst_name(employee.getFirst_name());
            exEmployee.setLast_name(employee.getLast_name());
            exEmployee.setEmail(employee.getEmail());
            exEmployee.setTitle(employee.getTitle());
            employeeRepository.save(exEmployee);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
}
