package Trab.DTOs.KeyDTOs;

import Trab.Model.TblKey;
import Trab.Model.TblSector;
import lombok.Data;


@Data
public class KeyResponseDTO {
    private Integer idKey;
    private String name;
    private Integer available;
    private TblSector Sector;    //Sector name (JOIN)

    public KeyResponseDTO(TblKey key) {
        this.idKey = key.getIdKey();
        this.name = key.getName();
        this.Sector = key.getSector();
        this.available = key.getAvailable();
    }


}
