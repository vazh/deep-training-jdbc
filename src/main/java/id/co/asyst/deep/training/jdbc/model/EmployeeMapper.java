package id.co.asyst.deep.training.jdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Employee employee = new Employee();

        employee.setId(rs.getInt("ID"));
        employee.setFirstName(rs.getString("FIRST_NAME"));
        employee.setLastName(rs.getString("LAST_NAME"));
        employee.setSalary(rs.getInt("SALARY"));
        employee.setAddress(rs.getString("ADDRESS"));
        employee.setPhone(rs.getString("PHONE"));

        return employee;
    }
}
