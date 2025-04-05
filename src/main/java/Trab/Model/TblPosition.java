package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "tbl_position")
public class TblPosition {

    @Id
    @Column(name= "idPosition")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPosition;
    @Column(name= "positionName")
    private String positionName;
    @Column(name= "idEmployee")
    private Integer idEmployee;
}
