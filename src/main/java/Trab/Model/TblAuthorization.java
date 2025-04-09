package Trab.Model;

import jakarta.persistence.*;
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
}
