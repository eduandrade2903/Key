package Model;
import lombok.*;

@Data
public class tblEmployee {
    //declaração das colunas dentro da tabela do DB
    private Integer idEmployee;
    private String  nameEmployee;
    private String  positionEmployee;
    private Integer idSector;

}
