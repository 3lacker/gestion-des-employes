package com.gestion.des.employes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.des.employes.model.Employee;
import com.gestion.des.employes.service.EmployeeService;
import com.gestion.des.employes.dto.EmployeeDTO;

import lombok.AllArgsConstructor;





@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDTO> getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employee) {      
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee is well added");
    }
    @PutMapping("/{id}")
    public Employee addEmployee(@PathVariable Long id , @RequestBody EmployeeDTO employee) {

        return employeeService.updateEmployee(id,employee);
    }


    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
    
    
    

    
}

