package Service;
import Model.TblEmployee;
import Repository.EmployeeRepository;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeService  {

 @Autowired
    private EmployeeRepository employeeRepository;
    //Cria no banco um novo colaborador
   public TblEmployee createEmployee(TblEmployee employee) {
       return employeeRepository.save(employee);
    }

    //Busca o colaborador pelo Id
    public TblEmployee getEmployeeById(Integer idEmployee) {
       return employeeRepository.findById(idEmployee).orElse(null);
    }

    //Atualiza qualquer dado do empregado
    public TblEmployee updateEmployeeById(Integer idEmployee, TblEmployee updatedEmployee) {
       //busca por id
       TblEmployee employee = getEmployeeById(idEmployee);

       //Se o calaborador for encontrado atualiza os dados
        if(employee != null) {
            if(updatedEmployee.getIdEmployee() != null ) {
                employee.setNameEmployee((updatedEmployee.getNameEmployee()));
            }
            if (updatedEmployee.getPositionEmployee() != null)  {
                employee.setPositionEmployee((updatedEmployee.getPositionEmployee()));
            }
            if (updatedEmployee.getIdSector() != null) {
                employee.setIdSector((updatedEmployee.getIdSector()));
            }
            }
            return employeeRepository.save(employee);
        }
    public void deleteEmployeeById(Integer idEmployee) {
          employeeRepository.deleteById(idEmployee);
    }

}

