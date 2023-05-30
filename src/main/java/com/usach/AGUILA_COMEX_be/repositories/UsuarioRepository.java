package com.usach.AGUILA_COMEX_be.repositories;

import com.usach.AGUILA_COMEX_be.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
