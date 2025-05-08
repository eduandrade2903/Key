package Trab.DTOs.LoanDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatedLoanDTO {

    @NotBlank (message = "id_Employee cannot be blank")
    private  Integer idEmployee;

    @NotBlank (message = "id_Key cannot be blank")
    private  Integer idKey;
}
