package Trab.Controller;

import Trab.DTOs.AuthorizationDto.AuthorizationResponseDTO;
import Trab.DTOs.AuthorizationDto.CreatedAuthorizationDTO;
import Trab.Model.TblAuthorization;
import Trab.Service.AuthorizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Authorization")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<AuthorizationResponseDTO>> getAllAuthorization() {
        List<TblAuthorization> authorizations = authorizationService.getAllAuthorization();
        List<AuthorizationResponseDTO> authorizationResponseDTOs = authorizations.stream().map(AuthorizationResponseDTO::new).toList();
        return ResponseEntity.ok(authorizationResponseDTOs);
    }

    // Aqui eu criei o endpoint para criar a autorização
    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<AuthorizationResponseDTO> createAuthorization(@RequestBody @Valid CreatedAuthorizationDTO authorization) {
        TblAuthorization createdAuthorization = authorizationService.createAuthorization(authorization);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthorizationResponseDTO(createdAuthorization));
    }

    // Aqui eu criei o endpoint para deletar a autorização
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorizationResponseDTO> deleteAuthorizationById(@PathVariable Integer id) {
        try {
            authorizationService.deleteAuthorizationById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
