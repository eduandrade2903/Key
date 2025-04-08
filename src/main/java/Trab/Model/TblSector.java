package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class TblSector {
    @Id
    @Column(name = "idsector")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSector;

    @Column(name = "namesector")
    private String nameSector;
}
