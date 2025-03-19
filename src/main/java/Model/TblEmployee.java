package Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_employee")
@Data
public class TblEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //declaração das colunas dentro da tabela do DB

    public Integer idEmployee;
    public  String nameEmployee;
    public String  positionEmployee;
    public Integer idSector;


}

