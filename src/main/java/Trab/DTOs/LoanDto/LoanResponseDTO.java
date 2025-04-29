package Trab.DTOs.LoanDto;

import Trab.Model.TblLoan;
import lombok.Data;

@Data
public class LoanResponseDTO {

    private Integer idLoan;
    private Integer idEmployee;
    private Integer idKey;

    public LoanResponseDTO(TblLoan loan) {
        this.idLoan = loan.getIdLoan();
        this.idEmployee = loan.getIdEmployee();
        this.idKey = loan.getIdKey();
    }
}
