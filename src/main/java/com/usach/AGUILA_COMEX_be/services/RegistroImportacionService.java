package com.usach.AGUILA_COMEX_be.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usach.AGUILA_COMEX_be.entities.RegistroImportacionEntity;
import com.usach.AGUILA_COMEX_be.repositories.RegistroImportacionRepository;

@Service
public class RegistroImportacionService {
    
    @Autowired
    private RegistroImportacionRepository registroImportacionRepository;

    public RegistroImportacionEntity create(RegistroImportacionEntity registro){
        return registroImportacionRepository.save(registro);
    }
    @Transactional
    public List<RegistroImportacionEntity> getAllRegImp(){
        return registroImportacionRepository.findAll();
    }

    @Transactional
    public Optional<RegistroImportacionEntity> findById (Long id){
        return registroImportacionRepository.findById(id);
    }

    @Transactional
    public RegistroImportacionEntity update (RegistroImportacionEntity registro, Long id){
        Optional<RegistroImportacionEntity> checkExistingReg = findById(id);
        if (!checkExistingReg.isPresent()){
            throw new RuntimeException("RegistroImportacion id " + id + " not found!");
        }
        registro.setId(id);
        return registroImportacionRepository.save(registro);
    }

    public void delete(Long id){
        registroImportacionRepository.deleteById(id);
    }

}
