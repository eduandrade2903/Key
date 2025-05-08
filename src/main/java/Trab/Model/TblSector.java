package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "tbl_sector")
public class TblSector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idSector;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return idSector;
    }
}
