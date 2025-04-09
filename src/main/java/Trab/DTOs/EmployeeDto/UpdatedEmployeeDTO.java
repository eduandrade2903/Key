package Trab.DTOs.EmployeeDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatedEmployeeDTO {

    @NotBlank
    private String nameEmployee;
    @NotNull
    private Integer idSector;
}
