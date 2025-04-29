package Trab.DTOs.EmployeeDto;

import Trab.Model.TblEmployee;
import Trab.Model.TblSector;
import lombok.Data;
import lombok.Getter;

@Data
public class EmployeeResponseDTO {
    // DTO for employee response
    private  Integer idEmployee;
    private  String nameEmployee;
    private TblSector idSector;

    public  EmployeeResponseDTO(TblEmployee emp) {
        this.idEmployee = emp.getIdEmployee();
        this.nameEmployee = emp.getNameEmployee();
        this.idSector = emp.getSector();
    }

    //public EmployeeResponseDTO(Integer idEmployee, String nameEmployee, Integer idSector) {
    //}
}
