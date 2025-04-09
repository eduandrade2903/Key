package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "tbl_sector")
public class TblSector {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSector;
    @Column(name = "name")
    private String nameSector;

}
