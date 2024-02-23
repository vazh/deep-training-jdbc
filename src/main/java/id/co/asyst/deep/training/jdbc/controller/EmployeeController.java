package id.co.asyst.deep.training.jdbc.controller;

import id.co.asyst.deep.training.jdbc.dao.EmployeeDAO;
import id.co.asyst.deep.training.jdbc.model.Employee;
import id.co.asyst.deep.training.jdbc.model.EmployeeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO;}

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        int result = employeeDAO.addEmployee(employee);
        if (result == 1) {
            return "BERHASIL";
        } else {
            return "GAGAL";
        }
    }
}
