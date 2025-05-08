package Trab.DTOs.AuthorizationDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatedAuthorizationDTO {

    @NotBlank(message = "ID do funcionário não pode ser nulo.")
    private Integer idEmployee;

    @NotBlank(message = "ID do setor não pode ser nulo.")
    private Integer idSector;
}
