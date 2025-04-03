package Trab.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class TblSector {
    @Id
    private Integer idSector;
    private String nameSector;
    private Integer idEmployee;
}
