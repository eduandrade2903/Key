package Trab.Controller;


import Trab.DTOs.EmployeeDto.EmployeeResponseDTO;
import Trab.DTOs.EmployeeDto.CreatedEmployeeDTO;
import Trab.DTOs.EmployeeDto.UpdatedEmployeeDTO;
import Trab.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Trab.Model.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id)
                .map(emp -> ResponseEntity.ok(new EmployeeResponseDTO(emp)))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody @Valid CreatedEmployeeDTO dto) {
        TblEmployee created = employeeService.createEmployee(dto);
        return new ResponseEntity<>(new EmployeeResponseDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Integer id, @RequestBody @Valid UpdatedEmployeeDTO dto) {
        try {
            TblEmployee updated = employeeService.updateEmployee(id, dto);
            return ResponseEntity.ok(new EmployeeResponseDTO(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<TblEmployee> employees = (List<TblEmployee>) employeeService.getAllEmployees();
        List<EmployeeResponseDTO> response = employees.stream()
                .map(EmployeeResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

}