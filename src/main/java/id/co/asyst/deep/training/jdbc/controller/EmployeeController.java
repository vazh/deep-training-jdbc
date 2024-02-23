package id.co.asyst.deep.training.jdbc.controller;

import id.co.asyst.deep.training.jdbc.model.Employee;
import id.co.asyst.deep.training.jdbc.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {this.repository = repository;}

    @GetMapping
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        int result = 1;
        if (result == 1) {
            return "BERHASIL";
        } else {
            return "GAGAL";
        }
    }

    @GetMapping("/salary")
    public List<Employee> getSalary() {
        return repository.fetchEmployeeBySalary(300000);
    }

    @GetMapping("/address")
    public List<Employee> getAddress() {
        return repository.findAllByAddress("BDO");
    }
}
