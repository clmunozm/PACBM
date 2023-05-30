package com.usach.AGUILA_COMEX_be.repositories;

import com.usach.AGUILA_COMEX_be.entities.PortsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortsRepository extends JpaRepository<PortsEntity, Long> {
}
