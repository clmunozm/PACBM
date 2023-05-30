package com.usach.AGUILA_COMEX_be.services;


import com.usach.AGUILA_COMEX_be.entities.PortsEntity;
import com.usach.AGUILA_COMEX_be.repositories.PortsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PortsService {

    @Autowired
    private PortsRepository portsRepository;

    @Transactional
    public PortsEntity create(PortsEntity portsEntity){
        return portsRepository.save(portsEntity);
    }
    @Transactional
    public List<PortsEntity> getAllPorts(){
        return portsRepository.findAll();
    }

    @Transactional
    public Optional<PortsEntity> findById (Long id){
        return portsRepository.findById(id);
    }

    @Transactional
    public PortsEntity update (PortsEntity portsEntity, Long id){
        Optional<PortsEntity> checkExistingBL = findById(id);
        if (!checkExistingBL.isPresent()){
            throw new RuntimeException("Ports id " + id + " not found!");
        }
        portsEntity.setId(id);
        return portsRepository.save(portsEntity);
    }

    @Transactional
    public void delete(Long id){
        portsRepository.deleteById(id);
    }
}
