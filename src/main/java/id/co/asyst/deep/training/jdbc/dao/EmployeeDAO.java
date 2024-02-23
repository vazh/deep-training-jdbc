package id.co.asyst.deep.training.jdbc.dao;

import id.co.asyst.deep.training.jdbc.model.Employee;
import id.co.asyst.deep.training.jdbc.model.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
    }

    public int addEmployee(Employee employee) {
        return jdbcTemplate
            .update("INSERT INTO EMPLOYEE(id, first_name, last_name, salary, address, phone) VALUES (?, ?, ?, ?, ?, ?)",
                employee.getId(), employee.getFirstName(),
                employee.getLastName(), employee.getSalary(),
                employee.getAddress(), employee.getPhone()
            );
    }
}
