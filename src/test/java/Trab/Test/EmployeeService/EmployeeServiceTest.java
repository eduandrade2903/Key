/*package Trab.Test.EmployeeService;

import Trab.DTOs.EmployeeDto.EmployeeResponseDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblSector;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import Trab.Service.EmployeeService;
import Trab.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testFindByid_returnsEmployeeDto() {
        Integer id = 1;
        TblSector idSector = new TblSector();
        TblEmployee employee = new TblEmployee();
        employee.setIdEmployee(id);
        employee.setNameEmployee("Dudu");
        idSector.setIdSector(1);


        TblEmployee Employee = new TblEmployee();
        EmployeeResponseDTO employeeDto = new EmployeeResponseDTO(Employee);
        employeeDto.setIdEmployee(id);
        employeeDto.setNameEmployee("Dudu");
        employeeDto.setIdSector(idSector);


        when(employeeRepository.findByidEmployee(id)).thenReturn(Optional.of(employee));
        when(modelMapper.map(employee, EmployeeResponseDTO.class)).thenReturn(employeeDto);

        Optional<TblEmployee> result = employeeService.getEmployeeById(id);

        assertNotNull(result);
        assertEquals(id, result.isEmpty());
        assertEquals("Dudu", result.getNameEmployee());
    }
}
*/
