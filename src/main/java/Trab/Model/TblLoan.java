package Trab.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table (name = "tbl_loan")
public class TblLoan {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoan;
    @Column (name = "id_employee")
    private Integer idEmployee;
    @Column (name = "id_key")
    private Integer idKey;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private TblEmployee employee;

    @OneToOne
    @NotNull
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private TblKey key;
}
