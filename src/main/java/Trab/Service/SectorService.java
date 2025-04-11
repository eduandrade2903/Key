package Trab.Service;

import Trab.DTOs.SectorDto.CreatedSectorDTO;
import Trab.DTOs.SectorDto.SectorResponseDTO;
import Trab.DTOs.SectorDto.UpdateSectorDTO;
import Trab.Model.TblSector;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorService {
     private SectorRepository sectorRepository;
     private final ModelMapper modelMapper;

     public List<TblSector> getAllSectors() {
         return sectorRepository.findAll();
     }

     public SectorResponseDTO getSectorById(Integer id) {
         TblSector sector = sectorRepository.findById(id).orElseThrow(() -> new RuntimeException("Setor nao encontrado"));
         return modelMapper.map(sector, SectorResponseDTO.class);
     }

     public TblSector createNewSector(CreatedSectorDTO sector) {
         TblSector _sector = new TblSector();
         _sector.setName(sector.getName());
         return sectorRepository.save(_sector);
     }

     public TblSector updateSector(Integer id, UpdateSectorDTO sector) {
         TblSector existingSector = sectorRepository.findById(id).orElseThrow(() -> new RuntimeException("Setor nao encontrado"));
         existingSector.setName(sector.getName());
         return sectorRepository.save(existingSector);
     }

    public void deleteSectorById(Integer id) {
        TblSector existingSector = sectorRepository.findById(id).orElseThrow(() -> new RuntimeException("Setor nao encontrado"));
        sectorRepository.delete(existingSector);
    }
}
