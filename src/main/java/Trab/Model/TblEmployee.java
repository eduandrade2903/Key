package Trab.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;


@Entity
@Data
@Table(name = "tbl_employee")
public class TblEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @NotNull
    private Integer idEmployee;
    @NotBlank
    @Column(name = "nameEmployee")
    private String  nameEmployee;
    @NotBlank
    @Column(name = "positionEmployee")
    private String  positionEmployee;
    @NotNull
    @Column(name = "idSector")
    private Integer idSector;


}

