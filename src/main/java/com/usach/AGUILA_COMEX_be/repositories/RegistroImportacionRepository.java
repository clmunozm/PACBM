package com.usach.AGUILA_COMEX_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usach.AGUILA_COMEX_be.entities.RegistroImportacionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroImportacionRepository extends JpaRepository<RegistroImportacionEntity, Long>{
    
}
