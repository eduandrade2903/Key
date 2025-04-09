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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer idEmployee;
    @NotBlank
    @Column(name = "name")
    private String  nameEmployee;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_Sector", nullable = false)
    private TblSector sector;


}

