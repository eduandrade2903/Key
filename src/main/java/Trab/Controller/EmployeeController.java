package Trab.Controller;


import Trab.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Trab.Model.TblEmployee;

import java.util.Optional;


@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Employee Controller";
    }

    @GetMapping("/{id}")
    public Optional<TblEmployee> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id)  ;
    }

    @GetMapping("/teste")
    public String teste() {
        return employeeService.puxa();
    }


    @PostMapping("/create")
    public ResponseEntity<TblEmployee> createEmployee(@RequestBody TblEmployee employee) {
        TblEmployee createdEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }


}