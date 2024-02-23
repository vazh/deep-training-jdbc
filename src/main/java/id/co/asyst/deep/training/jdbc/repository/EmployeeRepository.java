package id.co.asyst.deep.training.jdbc.repository;

import id.co.asyst.deep.training.jdbc.model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {

    @Query("SELECT * FROM employee WHERE salary >= :salary ")
    List<Employee> fetchEmployeeBySalary(@Param("salary") int salary);

    List<Employee> findAllByAddress(String address);

}
