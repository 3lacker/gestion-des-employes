package com.gestion.des.employes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gestion.des.employes.dto.EmployeeDTO;
import com.gestion.des.employes.model.Employee;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDto(Employee entity) {
        return EmployeeDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .department(entity.getDepartment())
                .build();
    }

    public Employee toEntity(EmployeeDTO dto) {
        return Employee.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .department(dto.getDepartment())
                .build();
    }
     public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
