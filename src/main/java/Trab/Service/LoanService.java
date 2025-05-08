package Trab.Service;


import Trab.DTOs.LoanDto.CreatedLoanDTO;
import Trab.DTOs.LoanDto.LoanResponseDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblKey;
import Trab.Model.TblLoan;
import Trab.Model.TblSector;
import Trab.Repository.*;
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
    private final AuthorizationRepository authorizationRepository;

    public TblLoan createLoan(CreatedLoanDTO loan) {
        Integer idEmployee = loan.getIdEmployee(); // <- pega o id do funcionário
        Integer idKey = loan.getIdKey(); // <- pega o id da chave

        TblEmployee employee = employeeRepository.findById(idEmployee)
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        TblKey key = keyRepository.findById(idKey)
                    .orElseThrow(() -> new RuntimeException("Chave não encontrada"));

        // Aqui eu verifico se a chave está disponível
        if(key.getAvailable() != 0){
            key.setAvailable(0);
            keyRepository.save(key);
        } else {
            throw new RuntimeException("Chave não disponivel.");
        }

        // Aqui eu verifico se o id do funcionario e o id do setor da chave estão cadastrados na tabela de authorizaçao.
        Integer keySector = key.getSector().getIdSector();
        boolean isAuthorized = authorizationRepository.existsByEmployeeIdAndSectorId(idEmployee, keySector);
        if (!isAuthorized) {
            throw new RuntimeException("Funcionário não autorizado a pegar a chave deste setor.");
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

    public void deleteLoanById(Integer id, Integer idKey) {
        auth.updateKey(idKey);


        loanRepository.deleteById(id);
    }
}
