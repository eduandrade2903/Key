package Trab.DTOs.EmployeeDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatedEmployeeDTO {
    @NotBlank(message = "Name cannot be blank")
    private String nameEmployee;
    @NotBlank(message = "Position cannot be blank")
    private String positionEmployee;
    @NotNull(message = "idSector cannot be null")
    private Integer idSector;
}
