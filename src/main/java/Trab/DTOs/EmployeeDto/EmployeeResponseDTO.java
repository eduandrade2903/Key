package Trab.DTOs.EmployeeDto;

import Trab.Model.TblEmployee;
import lombok.Data;
import lombok.Getter;

@Data
public class EmployeeResponseDTO {
    // DTO for employee response
    private  Integer idEmployee;
    private  String nameEmployee;
    private  String positionEmployee;
    private  Integer idSector;

    public  EmployeeResponseDTO(TblEmployee emp) {
        this.idEmployee = emp.getIdEmployee();
        this.nameEmployee = emp.getNameEmployee();
        this.positionEmployee = emp.getPositionEmployee();
        this.idSector = emp.getIdSector();
    }
}
