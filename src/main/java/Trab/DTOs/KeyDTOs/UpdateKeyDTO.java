package Trab.DTOs.KeyDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateKeyDTO {

    @NotNull
    private Integer available;
}
