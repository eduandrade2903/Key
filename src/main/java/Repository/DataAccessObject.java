package Repository;
import Model.tblEmployee;
import lombok.RequiredArgsConstructor;
import java.sql.*;

@RequiredArgsConstructor //Gera automaticamente o construtor que aceita 'Connection' como parâmetro
public class  DataAccessObject {
    //Conexão com banco de dados é obrigátoria e será injetada automaticamente
    private final Connection connection; //usado final para garantir que a conexão não será alterada

    //Classe de requisição ao banco                     //Throws lança uma exceção se ocorrer algum erro de consulta ao banco
    public tblEmployee getEmployeeById(int idEmployee) throws SQLException{
        String sql = "SELECT * FROM tbl_employee WHERE idEmployee = 1"; //Query SQL para buscar um empregado pelo ID
        //Usado o try-with-resources para garantir
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idEmployee);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                tblEmployee employee = new tblEmployee();
                employee.setIdEmployee(resultSet.getInt("idEmployee"));
                employee.setPositionEmployee(resultSet.getString("positionEmployee"));
                employee.setNameEmployee((resultSet.getString("nameEmployee")));

            }
        }
        return null;
    }

}




