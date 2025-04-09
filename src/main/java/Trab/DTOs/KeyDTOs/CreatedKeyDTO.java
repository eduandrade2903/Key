package Trab.DTOs.KeyDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedKeyDTO {
    @NotBlank(message = "IdKey cannot be blank")
    private Integer idKey;
    @NotBlank(message = "name cannot be blank")
    private String name;



}



