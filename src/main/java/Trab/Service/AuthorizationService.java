package Trab.Service;

import Trab.DTOs.AuthorizationDto.CreatedAuthorizationDTO;
import Trab.Model.TblAuthorization;
import Trab.Repository.AuthorizationRepository;
import Trab.Repository.EmployeeRepository;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final EmployeeRepository employeeRepository;
    private final SectorRepository sectorRepository;
    private final AuthorizationRepository authorizationRepository;

    public TblAuthorization createAuthorization(CreatedAuthorizationDTO authorization) {
        Integer idEmployee = authorization.getIdEmployee();
        Integer idSector = authorization.getIdSector();

        // Aqui eu checo se o funcionário existe, se nao existir, lanço uma exceção
        if (!employeeRepository.existsById(idEmployee)) {
            throw new RuntimeException("Funcionário não encontrado");
        }

        // Aqui eu checo se o setor existe
        if (!sectorRepository.existsById(idSector)) {
            throw new RuntimeException("Setor não encontrado");
        }

        TblAuthorization auth = new TblAuthorization();
        auth.setIdEmployee(authorization.getIdEmployee());
        auth.setIdSector(authorization.getIdSector());

        return authorizationRepository.save(auth);
    }

    public void deleteAuthorizationById(Integer id) {
        TblAuthorization auth = authorizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autorização não encontrada"));
        authorizationRepository.delete(auth);
    }

    public List<TblAuthorization> getAllAuthorization() {
        return authorizationRepository.findAll();
    }

}
