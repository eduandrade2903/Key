package Trab.DTOs.LoanDto;

import Trab.Model.TblLoan;
import lombok.Data;

@Data
public class LoanResponseDTO {

    private Integer idLoan;
    private Object Employee;
    private Object Key;

    public LoanResponseDTO(TblLoan loan) {
        this.idLoan = loan.getIdLoan();
        this.Employee = loan.getEmployee();
        this.Key = loan.getKey();
    }
}
