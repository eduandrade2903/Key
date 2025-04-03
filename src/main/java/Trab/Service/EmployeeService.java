package Trab.Service;
import Trab.Model.TblEmployee;
import Trab.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

   public String puxa(){
       return "Funciona bosta";
    }

    //Atualiza qualquer dado do empregado
    public TblEmployee updateEmployee(TblEmployee employee) {
        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Integer idEmployee) {
          employeeRepository.deleteById(idEmployee);
    }

    //Retorna todos os empregados
    public List<TblEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}

