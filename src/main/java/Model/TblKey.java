package Model;
import lombok.*;
import java.util.Date;

@Data
public class TblKey {
    private Integer idKey;
    private Integer idSector;
    private String  keyDescription;
    private Date    withDrawDate;
    private Date    returnDate;
}


