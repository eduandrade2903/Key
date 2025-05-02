package Trab.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_authorization")
public class TblAuthorization {

    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthorization;
    @Column (name = "id_employee")
    private Integer idEmployee;
    @Column (name = "id_sector")
    private Integer idSector;

    @OneToOne
    @NotNull
    @JoinColumn (name = "id_employee", nullable = false, insertable = false, updatable = false)
    private TblEmployee employee;

    @OneToOne
    @NotNull
    @JoinColumn (name = "id_sector", nullable = false, insertable = false, updatable = false)
    private TblSector sector;
}
