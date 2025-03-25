/*package Controller;

import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Model.TblEmployee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/tbl_employee/{idEmployee}")
    public TblEmployee getEmployeeById(@PathVariable Integer idEmployee) {
        return employeeService.getEmployeeById(idEmployee);
    }

}*/
