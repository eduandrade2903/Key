package Trab.Service;
import Trab.DTOs.EmployeeDto.CreatedEmployeeDTO;
import Trab.DTOs.EmployeeDto.UpdatedEmployeeDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblSector;
import Trab.Repository.EmployeeRepository;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService  {


    private final EmployeeRepository employeeRepository;
    private final SectorRepository sectorRepository;
    private final ModelMapper modelMapper;

    //Creates a new employee
        public TblEmployee createEmployee(CreatedEmployeeDTO dto) {
            Integer idSector = dto.getIdSector(); // <- se isso aqui vier null, já era

            TblSector sector = sectorRepository.findById(idSector)
                    .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

            TblEmployee employee = new TblEmployee();
            employee.setNameEmployee(dto.getNameEmployee());
            employee.setSector(sector);

            return employeeRepository.save(employee);
        }


   /// Busca o colaborador pelo Id
   public Optional<TblEmployee> getEmployeeById(Integer idEmployee) {
       return employeeRepository.findByidEmployee(idEmployee);
    }

    //Update employee by id
   public TblEmployee updateEmployee(Integer id, UpdatedEmployeeDTO dto) {
     TblEmployee emp = employeeRepository.findByidEmployee(id)
             .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

     TblSector sector = sectorRepository.findById(dto.getIdSector())
             .orElseThrow(() -> new RuntimeException("Sector not found with id: " + dto.getIdSector()));
     TblEmployee name = employeeRepository.findBynameEmployee(dto.getNameEmployee())
                .orElseThrow(() -> new RuntimeException("Employee not found with name: " + dto.getNameEmployee()));
     emp.setSector(sector);
     emp.setNameEmployee(dto.getNameEmployee());

       return employeeRepository.save(emp);
    }

    public void deleteEmployeeById(Integer id) {
       employeeRepository.deleteById(id);
    }

    public List<TblEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}





