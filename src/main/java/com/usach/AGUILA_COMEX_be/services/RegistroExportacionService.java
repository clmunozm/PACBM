package com.usach.AGUILA_COMEX_be.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usach.AGUILA_COMEX_be.entities.RegistroExportacionEntity;
import com.usach.AGUILA_COMEX_be.repositories.RegistroExportacionRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistroExportacionService {

    @Autowired
    private RegistroExportacionRepository registroExportacionRepository;

    @Transactional
    public RegistroExportacionEntity create(RegistroExportacionEntity registro){
        return registroExportacionRepository.save(registro);
    }
    @Transactional
    public List<RegistroExportacionEntity> getAllRegExp(){
        return registroExportacionRepository.findAll();
    }

    @Transactional
    public Optional<RegistroExportacionEntity> findById (Long id){
        return registroExportacionRepository.findById(id);
    }

    @Transactional
    public RegistroExportacionEntity update (RegistroExportacionEntity registro, Long id){
        Optional<RegistroExportacionEntity> checkExistingReg = findById(id);
        if (!checkExistingReg.isPresent()){
            throw new RuntimeException("RegistroExportacion id " + id + " not found!");
        }
        registro.setId(id);
        return registroExportacionRepository.save(registro);
    }

    public void delete(Long id){
        registroExportacionRepository.deleteById(id);
    }
    
}
