package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class TblPosition {

    @Id
    @Column(name= "idposition")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPosition;

    @Column(name= "positionname")
    private String positionName;
}
