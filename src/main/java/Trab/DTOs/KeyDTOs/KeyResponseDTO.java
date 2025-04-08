package Trab.DTOs.KeyDTOs;

import Trab.Model.TblKey;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class KeyResponseDTO {
    private Integer idKey;
    private String keyDescription;
    private LocalDateTime withDrawalDate;
    private  LocalDateTime returnDate;

    private Integer idSector;      //Direct Fk (if needs ID)
    private String nameSector;     //Sector name (JOIN)

    public KeyResponseDTO(TblKey key) {
        this.idKey = key.getIdKey();
        this.keyDescription = key.getKeyDescription();
        this.withDrawalDate = key.getWithDrawDate();
        this.returnDate = key.getReturnDate();
    }


}
