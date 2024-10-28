package com.gestion.des.employes.service;
import com.gestion.des.employes.model.Employee;
import com.gestion.des.employes.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    List<EmployeeDTO> getAllEmployees();

    Optional<EmployeeDTO> getEmployeeById(Long id);

    Employee addEmployee(EmployeeDTO Employee);

    Employee updateEmployee(Long id, EmployeeDTO EmployeeDto);

    void deleteEmployee(Long id);
}
