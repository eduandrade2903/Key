package Trab.DTOs.KeyDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedKeyDTO {
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "Sempre começa com TRUE")
    private boolean available;

    @NotNull(message = "É obrigatório informar o setor")
    private Integer idSector;



}



