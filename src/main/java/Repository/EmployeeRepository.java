package Repository;

import Model.TblEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<TblEmployee, Integer> {

}
