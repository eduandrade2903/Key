package Trab.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Data
public class TblKey {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="idkey")
    private Integer idKey;
    @Column(name = "idsector")
    private Integer idSector;
    @Column(name = "keydescription")
    private String  keyDescription;
    @Setter
    @Column(name = "keywithdrawdate")
    private Date    withDrawDate;
    @Setter
    @Column(name = "returndate")
    private Date    returnDate;

}


