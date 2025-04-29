package Trab.Service;


import Trab.DTOs.LoanDto.LoanResponseDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblKey;
import Trab.Model.TblLoan;
import Trab.Model.TblSector;
import Trab.Repository.EmployeeRepository;
import Trab.Repository.KeyRepository;
import Trab.Repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private LoanRepository loanRepository;
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    private KeyRepository keyRepository;


    public TblLoan createLoan(LoanResponseDTO loan) {
        Integer idEmployee = loan.getIdEmployee(); // <- pega o id do funcionário

        TblEmployee employee = employeeRepository.findById(idEmployee)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Integer idKey = loan.getIdKey(); // <- pega o id do setor

        TblKey key = keyRepository.findById(idKey)
                .orElseThrow(() -> new RuntimeException("Chave não encontrada"));

        TblLoan loanEmp = new TblLoan();
        loanEmp.setIdEmployee(loan.getIdEmployee());
        loanEmp.setIdKey(loan.getIdKey());

        return loanRepository.save(loanEmp);
    }

}
