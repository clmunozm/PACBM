package com.usach.AGUILA_COMEX_be.repositories;

import com.usach.AGUILA_COMEX_be.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    
}
