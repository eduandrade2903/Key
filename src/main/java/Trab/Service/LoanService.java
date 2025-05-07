package Trab.Service;


import Trab.DTOs.LoanDto.CreatedLoanDTO;
import Trab.DTOs.LoanDto.LoanResponseDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblKey;
import Trab.Model.TblLoan;
import Trab.Model.TblSector;
import Trab.Repository.EmployeeRepository;
import Trab.Repository.KeyRepository;
import Trab.Repository.LoanRepository;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    //private ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;
    private final KeyRepository keyRepository;
    private final KeyService auth;
    private final SectorRepository sectorRepository;

    public TblLoan createLoan(CreatedLoanDTO loan) {
        Integer idEmployee = loan.getIdEmployee(); // <- pega o id do funcionário
        TblEmployee employee = employeeRepository
                .findById(idEmployee)
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        Integer idKey = loan.getIdKey(); // <- pega o id da chave
        TblKey key = keyRepository
                .findById(idKey)
                    .orElseThrow(() -> new RuntimeException("Chave não encontrada"));

        Integer IdEmp = employee
                .getSector()
                    .getIdSector(); // <- pega o id do setor do funcionário
        Integer idKy = key
                .getSector()
                    .getIdSector(); // <- pega o id do setor da chave

        if(!IdEmp.equals(idKy)) {
            throw new RuntimeException("Chave e funcionário não pertencem ao mesmo setor");
        }
        TblLoan loanEmp = new TblLoan();
        loanEmp.setIdEmployee(loan.getIdEmployee());
        loanEmp.setIdKey(loan.getIdKey());

        return loanRepository.save(loanEmp);
    }

    public List<TblLoan> getAllLoans() {
               return loanRepository.findAll();

    }

    public TblLoan findById(Integer id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }
    public void deleteLoanById(Integer id) {
        loanRepository.deleteById(id);
    }
}
