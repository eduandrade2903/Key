package Trab.Controller;

import Trab.DTOs.KeyDTOs.CreatedKeyDTO;
import Trab.DTOs.KeyDTOs.KeyResponseDTO;
import Trab.Model.TblKey;
import Trab.Service.KeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Key")
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyservice;

    // Add methods to handle requests related to keys

    @GetMapping("/{id}")
    public Optional<TblKey> getKeyById(@PathVariable Integer id) {
        return keyservice.serchKeyById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<KeyResponseDTO>> getAllKeys() {
        List<TblKey> keys = keyservice.getAllKeys();
        List<KeyResponseDTO> response = keys.stream()
                .map(KeyResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<KeyResponseDTO> createKey(@RequestBody @Valid CreatedKeyDTO key) {
        TblKey created = keyservice.createNewKey(key);
        return new ResponseEntity<>(new KeyResponseDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<KeyResponseDTO> updateKey(@PathVariable Integer id) {
        try {
            TblKey updatedKey = keyservice.updateKey(id);
            return ResponseEntity.ok(new KeyResponseDTO(updatedKey));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKey(@PathVariable Integer id) {
        keyservice.deleteKeyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
