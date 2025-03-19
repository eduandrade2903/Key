package Repository;

import Model.TblEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<TblEmployee, Integer> {

}
