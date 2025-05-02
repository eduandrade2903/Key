package Trab.DTOs.AuthorizationDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorizationResponseDTO {

    @NotBlank (message = "idAuthorization cannot be blank")
    private Integer idAuthorization;
    @NotBlank (message = "idEmployee cannot be blank")
    private Integer idEmployee;
    @NotBlank (message = "idSector cannot be blank")
    private Integer idSector;
}
