package Trab.DTOs.SectorDto;

import Trab.Model.TblSector;
import lombok.Data;

@Data
public class SectorResponseDTO {
    private Integer id;
    private String name;

    public SectorResponseDTO(TblSector sector) {
        this.id = sector.getIdSector();
        this.name = sector.getName();
    }
}
