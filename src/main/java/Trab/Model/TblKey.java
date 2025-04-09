package Trab.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tbl_key")
public class TblKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer idKey;

    @Column(name = "name")
    private String  name;

    @Column(name = "available")
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "id_Sector", nullable = false)
    private TblSector sector;

}


