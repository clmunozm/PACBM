package com.usach.AGUILA_COMEX_be.repositories;

import com.usach.AGUILA_COMEX_be.entities.OperationNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OperationNumberRepository extends JpaRepository<OperationNumberEntity, Long> {
    @Query(value = "ALTER SEQUENCE operation_number_id_seq RESTART WITH 1",nativeQuery = true)
    @Modifying
    @Transactional
    void resetID();
}
