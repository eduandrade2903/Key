package Trab.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Data
@Table(name = "tbl_key")
public class TblKey {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="idKey")
    private Integer idKey;
    @Column(name = "idSector")
    private Integer idSector;
    @Column(name = "keyDescription")
    private String  keyDescription;
    @Setter
    @Column(name = "keywithDrawdate")
    private Date    withDrawDate;
    @Setter
    @Column(name = "returnDate")
    private Date    returnDate;

}


