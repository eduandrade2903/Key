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

    public void setWithDrawDate(Date withDrawDate) {
        this.withDrawDate = withDrawDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}


