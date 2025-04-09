package Trab.DTOs.KeyDTOs;

import Trab.Model.TblKey;
import Trab.Model.TblSector;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class KeyResponseDTO {
    private Integer idKey;
    private String Name;
    private TblSector Sector;    //Sector name (JOIN)

    public KeyResponseDTO(TblKey key) {
        this.idKey = key.getIdKey();
        this.Name = key.getName();
        this.Sector = key.getSector();
    }


}
