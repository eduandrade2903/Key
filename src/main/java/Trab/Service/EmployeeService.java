package Trab.Service;
import Trab.DTOs.EmployeeDto.CreatedEmployeeDTO;
import Trab.DTOs.EmployeeDto.UpdatedEmployeeDTO;
import Trab.Model.TblEmployee;
import Trab.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService  {


    private final EmployeeRepository employeeRepository;

    //Creates a new employee
    public TblEmployee createEmployee(CreatedEmployeeDTO dto) {
        TblEmployee emp = new TblEmployee();
        emp.setNameEmployee(dto.getNameEmployee());
        emp.setPositionEmployee(dto.getPositionEmployee());
        emp.setIdSector(dto.getIdSector());
        return employeeRepository.save(emp);
    }

    //Busca o colaborador pelo Id
    public Optional<TblEmployee> getEmployeeById(Integer idEmployee) {
        return employeeRepository.findByidEmployee(idEmployee);
    }

    //Update employee by id
    public TblEmployee updateEmployee(Integer id, UpdatedEmployeeDTO dto) {
        TblEmployee emp = employeeRepository.findByidEmployee(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        emp.setNameEmployee(dto.getNameEmployee());
        emp.setPositionEmployee(dto.getPositionEmployee());
        emp.setIdSector(dto.getIdSector());

        return employeeRepository.save(emp);
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<TblEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}






