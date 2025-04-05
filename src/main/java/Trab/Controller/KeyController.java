package Trab.Controller;

import Trab.Model.TblKey;
import Trab.Service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<TblKey> createKey(@RequestBody TblKey key) {
        TblKey createdKey = keyservice.createNewKey(key);
        return new ResponseEntity<>(createdKey, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TblKey> updateKey(@PathVariable Integer id, @RequestBody TblKey keyDetails) {
        try {
            TblKey updatedKey = keyservice.createDescription(keyDetails);
            return ResponseEntity.ok(updatedKey);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
