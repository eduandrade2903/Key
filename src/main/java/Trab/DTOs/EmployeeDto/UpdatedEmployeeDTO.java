package Trab.DTOs.EmployeeDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatedEmployeeDTO {

    @NotBlank
    private String nameEmployee;
    @NotBlank
    private String positionEmployee;
    @NotNull
    private Integer idSector;
}
