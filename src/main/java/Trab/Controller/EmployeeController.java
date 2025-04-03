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

    @GetMapping("/{id}")
    public Optional<TblEmployee> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id)  ;
    }

    @PostMapping("/create")
    public ResponseEntity<TblEmployee> createEmployee(@RequestBody TblEmployee employee) {
        TblEmployee createdEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TblEmployee> updateEmployee(@PathVariable Integer id, @RequestBody TblEmployee employeeDetails) {
        try {
            TblEmployee updateEmployee = employeeService.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updateEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<TblEmployee>> getAllEmployees() {
        Iterable<TblEmployee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}