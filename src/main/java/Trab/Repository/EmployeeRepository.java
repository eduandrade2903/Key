package Trab.Repository;

import Trab.Model.TblEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<TblEmployee, Integer> {


    public Optional<TblEmployee> findByidEmployee(Integer id);

}
