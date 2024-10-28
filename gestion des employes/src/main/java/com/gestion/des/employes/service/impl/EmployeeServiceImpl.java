package com.gestion.des.employes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.gestion.des.employes.model.Employee;
import com.gestion.des.employes.repository.EmployeeRepository;
import com.gestion.des.employes.service.EmployeeService;
import com.gestion.des.employes.dto.EmployeeDTO;
import com.gestion.des.employes.exception.EmployeeException;
import com.gestion.des.employes.mapper.EmployeeMapper;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees");
        return  employeeMapper.toDto(employeeRepository.findAll());
    }
    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("messageSource.getMessage("employee-not-found", null, locale)"));

        return Optional.of(employeeMapper.toDto(employee));
    }
    @Override

    public Employee addEmployee(EmployeeDTO employee) {
        log.info("Adding new employee: {}", employee.getId());
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new EmployeeException("Email already in use");
        }
        return employeeRepository.save(employeeMapper.toEntity(employee));
    }
    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDto) {
        log.info("Updating employeeDto with id: {}", id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceAccessException("messageSource.getMessage("employee-not-found", null, locale)"));

        return employeeRepository.save(employeeMapper.toEntity(employeeDto));
    }
    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);
        employeeRepository.deleteById(id);
    }


}

