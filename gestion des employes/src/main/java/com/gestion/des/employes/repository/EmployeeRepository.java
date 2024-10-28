package com.gestion.des.employes.repository;
import com.gestion.des.employes.dto.EmployeeDTO;
import com.gestion.des.employes.model.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<EmployeeDTO> findByEmail(String email);
}
