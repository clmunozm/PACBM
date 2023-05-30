package com.usach.AGUILA_COMEX_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usach.AGUILA_COMEX_be.entities.RegistroExportacionEntity;
import com.usach.AGUILA_COMEX_be.services.RegistroExportacionService;

@RestController
@RequestMapping("/regexp")
public class RegistroExportacionController {
    
    @Autowired
    private RegistroExportacionService registroExportacionService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    private RegistroExportacionEntity save(@RequestBody RegistroExportacionEntity data){
        return registroExportacionService.create(data);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    private List<RegistroExportacionEntity> findAllReg (){
        return registroExportacionService.getAllRegExp();
    }

    @GetMapping("/{id}")
    private Optional<RegistroExportacionEntity> findReg(@PathVariable("id") Long id){
        return registroExportacionService.findById(id);
    }

    @PutMapping("/{id}")
    private RegistroExportacionEntity updateRE(@RequestBody RegistroExportacionEntity registroExportacionEntity, @PathVariable("id") Long id){
        return registroExportacionService.update(registroExportacionEntity, id);
    }

    @DeleteMapping("/{id}")
    private void deleteRE(@PathVariable("id") Long id){
        registroExportacionService.delete(id);
    }

}
