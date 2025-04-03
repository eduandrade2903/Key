package Trab.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class TblPosition {

    @Id

    private Integer idPosition;
    private String positionName;
    private Integer idEmployee;
}
