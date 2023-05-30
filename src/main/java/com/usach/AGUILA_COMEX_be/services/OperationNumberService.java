package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.OperationNumberEntity;
import com.usach.AGUILA_COMEX_be.repositories.OperationNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class OperationNumberService {

    @Autowired
    private OperationNumberRepository operationNumberRepository;

    @Transactional
    public Integer retrieveCurrent(){

        if (operationNumberRepository.findById(1L).isEmpty()){
            throw new RuntimeException("Número correlativo actual de operación no encontrado");
        }
        else {
            Integer current = operationNumberRepository.findById(1L).get().getCurrent_operation_number();
            Integer next = current+1;
            OperationNumberEntity operationNumberEntity = new OperationNumberEntity();
            operationNumberEntity.setCurrent_operation_number(next);
            operationNumberEntity.setId(1L);
            operationNumberRepository.save(operationNumberEntity);
            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Santiago"));
            int mes = localDateTime.getMonthValue();
            int anio = localDateTime.getYear()%100;
            int combinacion = anio*100+mes;
            return Integer.parseInt(String.valueOf(combinacion)+ current);
        }
    }
}
