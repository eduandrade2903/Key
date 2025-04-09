package Trab.DTOs.KeyDTOs;

import Trab.Model.TblKey;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class KeyResponseDTO {
    private Integer idKey;
    private String Name;


    private Integer idSector;      //Direct Fk (if needs ID)
    private String nameSector;     //Sector name (JOIN)

    public KeyResponseDTO(TblKey key) {
        this.idKey = key.getIdKey();
        this.Name = key.getName();
    }


}
