package Trab.Controller;

import Trab.DTOs.SectorDto.CreatedSectorDTO;
import Trab.DTOs.SectorDto.SectorResponseDTO;
import Trab.DTOs.SectorDto.UpdateSectorDTO;
import Trab.Model.TblSector;
import Trab.Service.SectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Sector")
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<SectorResponseDTO>> getAll() {
        List<TblSector> sectors = sectorService.getAllSectors();
        List<SectorResponseDTO> response = sectors.stream()
                .map(SectorResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Optional<TblSector> getById(@PathVariable("id") Integer Id){
        return sectorService.getSectorById(Id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<SectorResponseDTO> create(@RequestBody @Valid CreatedSectorDTO sector) {
        TblSector created = sectorService.createNewSector(sector);
        return ResponseEntity.status(201).body(new SectorResponseDTO(created));
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<SectorResponseDTO> update(@PathVariable Integer id, @RequestBody @Valid UpdateSectorDTO sector) {
        try {
            TblSector updatedSector = sectorService.updateSector(id, sector);
            return ResponseEntity.ok(new SectorResponseDTO(updatedSector));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            sectorService.deleteSectorById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
