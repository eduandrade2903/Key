package Trab.Model;

import jakarta.persistence.*;
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
}
