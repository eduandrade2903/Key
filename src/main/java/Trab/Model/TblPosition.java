package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class TblPosition {

    @Id
    @Column(name= "idposition")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPosition;
    @Column(name= "positionname")
    private String positionName;
    @Column(name= "idemployee")
    private Integer idEmployee;
}
