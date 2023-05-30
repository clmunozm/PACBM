package com.usach.AGUILA_COMEX_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usach.AGUILA_COMEX_be.entities.RegistroImportacionEntity;
import com.usach.AGUILA_COMEX_be.services.RegistroImportacionService;

@RestController
@RequestMapping("/regimp")
public class RegistroImportacionController {
    
    @Autowired
    private RegistroImportacionService registroImportacionService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    private RegistroImportacionEntity save(@RequestBody RegistroImportacionEntity data){
        return registroImportacionService.create(data);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    private List<RegistroImportacionEntity> findAllReg (){
        return registroImportacionService.getAllRegImp();
    }

    @GetMapping("/{id}")
    private Optional<RegistroImportacionEntity> findReg(@PathVariable("id") Long id){
        return registroImportacionService.findById(id);
    }

    @PutMapping("/{id}")
    private RegistroImportacionEntity updateRI(@RequestBody RegistroImportacionEntity registroImportacionEntity, @PathVariable("id") Long id){
        return registroImportacionService.update(registroImportacionEntity, id);
    }

    @DeleteMapping("/{id}")
    private void deleteRI(@PathVariable("id") Long id){
        registroImportacionService.delete(id);
    }
    
}
