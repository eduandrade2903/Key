package Trab.Controller;


import Trab.DTOs.LoanDto.CreatedLoanDTO;
import Trab.DTOs.LoanDto.LoanResponseDTO;
import Trab.Model.TblLoan;
import Trab.Service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<LoanResponseDTO>> getAllLoans() {
        List<TblLoan> loans = loanService.getAllLoans();
        List<LoanResponseDTO> loanResponseDTOs = loans.stream().map(LoanResponseDTO::new).toList();
        return ResponseEntity.ok(loanResponseDTOs);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody @Valid CreatedLoanDTO loan) {
        TblLoan createdLoan = loanService.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoanResponseDTO(createdLoan));

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}/{idKey}")
    public ResponseEntity<LoanResponseDTO> deleteLoanById(@PathVariable Integer id,@PathVariable Integer idKey) {
        try {
            loanService.deleteLoanById(id, idKey);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
