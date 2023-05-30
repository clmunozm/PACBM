package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.BLEntity;
import com.usach.AGUILA_COMEX_be.repositories.BLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BLService {

    @Autowired
    private BLRepository blRepository;

    @Transactional
    public BLEntity create(BLEntity bl){
        return blRepository.save(bl);
    }
    @Transactional
    public List<BLEntity> getAllBL(){
        return blRepository.findAll();
    }

    @Transactional
    public Optional<BLEntity> findById (Long id){
        return blRepository.findById(id);
    }

    @Transactional
    public BLEntity update (BLEntity bl, Long id){
        Optional<BLEntity> checkExistingBL = findById(id);
        if (!checkExistingBL.isPresent()){
            throw new RuntimeException("BL id " + id + " not found!");
        }
        bl.setId(id);
        return blRepository.save(bl);
    }

    @Transactional
    public void delete(Long id){
        blRepository.deleteById(id);
    }

    @Transactional
    public Optional<BLEntity> findByOpID(int opid){
        return blRepository.findByOperation_id(opid);
    }
}
