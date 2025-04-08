package Trab.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Data
public class TblKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idkey")
    private Integer idKey;

    @Column(name = "idsector")
    private Integer idSector;

    @Column(name = "keydescription")
    private String  keyDescription;

    @Setter
    @Column(name = "withdrawdate")
    private Date    withdrawDate;

    @Setter
    @Column(name = "returndate")
    private Date    returnDate;

}


