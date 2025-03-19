package Model;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_employee")
public class TblEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //declaração das colunas dentro da tabela do DB

    public Integer idEmployee;
    public  String nameEmployee;
    public String  positionEmployee;
    public Integer idSector;

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }
}

