package Service;
import Model.TblEmployee;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService  {

    @Autowired
    private EmployeeRepository employeeRepository;


    //Cria no banco um novo colaborador
   public TblEmployee createEmployee(TblEmployee employee) {
       return employeeRepository.save(employee);
    }

    //Busca o colaborador pelo Id
   public Optional<TblEmployee> getEmployeeById(Integer idEmployee) {
      return employeeRepository.findById(idEmployee);
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

