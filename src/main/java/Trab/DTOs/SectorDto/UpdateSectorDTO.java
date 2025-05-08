package Trab.DTOs.SectorDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateSectorDTO {

    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
}
