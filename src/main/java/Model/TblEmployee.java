package Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TblEmployee {


    public Integer idEmployee;
    public String nameEmployee;
    public String  positionEmployee;
    public Integer idSector;


}

