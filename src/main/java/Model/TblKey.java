package Model;
import lombok.*;
import java.util.Date;

@Data
public class tblKey {
    Integer idKey;
    Integer idSector;
    String  keyDescription;
    Date    withdrawDate;
    Date    returnDate;
}
