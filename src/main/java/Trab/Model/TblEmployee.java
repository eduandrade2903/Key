package Trab.Model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class TblEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEmployee;

    @Column(name = "nameemployee")
    private String  nameEmployee;

    @Column(name = "idposition")
    private Integer  idPosition;

    @Column(name = "idsector")
    private Integer idSector;


}

