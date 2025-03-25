package Controller;

import Model.TblKey;
import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import Model.TblEmployee;

import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<TblEmployee> createEmployee(@RequestBody TblEmployee employee) {
        TblEmployee createdEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TblEmployee> getEmployeeByid(@PathVariable Integer id) {
        Optional<TblEmployee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
