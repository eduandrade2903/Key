package Trab.Model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class TblEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer idEmployee;

    @Column(name = "nameemployee")
    private String  nameEmployee;

    @Column(name = "positionemployee")
    private String  positionEmployee;

    @Column(name = "idsector")
    private Integer idSector;


}

