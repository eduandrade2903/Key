package Trab.Service;
import Trab.Model.TblEmployee;
import Trab.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService  {


    private final EmployeeRepository employeeRepository;

    //Cria no banco um novo colaborador
   public TblEmployee createEmployee(TblEmployee employee) {
       return employeeRepository.save(employee);
    }

    //Busca o colaborador pelo Id
   public Optional<TblEmployee> getEmployeeById(Integer idEmployee) {
      return employeeRepository.findByidEmployee(idEmployee);
   }

    //Atualiza qualquer dado do empregado
   public TblEmployee updateEmployee(Integer id, TblEmployee employeeDetails) {
       return employeeRepository.findByidEmployee(id)
               .map(employee -> {
                employee.setNameEmployee(employeeDetails.getNameEmployee());
                employee.setPositionEmployee(employeeDetails.getPositionEmployee());
                employee.setIdSector(employeeDetails.getIdSector());
                return employeeRepository.save(employee);
            }
       ).orElseThrow(() -> new RuntimeException("Employee not found wiht id: " + id));
   }
    //Deleta o empregado pelo id
    public void deleteEmployeeById(Integer idEmployee) {
          employeeRepository.deleteById(idEmployee);
    }

    //Retorna todos os empregados
    public List<TblEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }


}

