package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "tbl_sector")
public class TblSector {
    @Id
    @Column(name = "idSector")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSector;
    @Column(name = "nameSector")
    private String nameSector;
    @Column(name = "idEmployee")
    private Integer idEmployee;
}
