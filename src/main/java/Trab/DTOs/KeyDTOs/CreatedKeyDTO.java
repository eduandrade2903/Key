package Trab.DTOs.KeyDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedKeyDTO {
    @NotBlank(message = "IdKey cannot be blank")
    private Integer idKey;
    @NotBlank(message = "KeyDescription cannot be blank")
    private String keyDescription;
    @NotBlank(message = "WithDrawalDate cannot be blank")
    private LocalDateTime withDrawalDate;
    @NotBlank(message = "ReturnDate cannot be blank")
    private LocalDateTime returnDate;


}



