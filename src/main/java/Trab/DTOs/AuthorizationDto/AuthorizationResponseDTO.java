package Trab.DTOs.AuthorizationDto;

import Trab.Model.TblAuthorization;
import lombok.Data;

@Data
public class AuthorizationResponseDTO {


    private Integer idAuthorization;
    private Object Employee;
    private Object Sector;

    public AuthorizationResponseDTO(TblAuthorization authorization) {
        this.idAuthorization = authorization.getIdAuthorization();
        this.Employee = authorization.getEmployee();
        this.Sector = authorization.getSector();
    }
}
