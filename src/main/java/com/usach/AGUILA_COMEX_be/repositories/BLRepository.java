package com.usach.AGUILA_COMEX_be.repositories;

import com.usach.AGUILA_COMEX_be.entities.BLEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BLRepository extends JpaRepository<BLEntity, Long> {
    @Query("select bl from BLEntity bl where bl.operation_id = :opid")
    Optional<BLEntity> findByOperation_id(int opid);

}
