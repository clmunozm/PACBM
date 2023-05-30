package com.usach.AGUILA_COMEX_be.controllers;

import com.usach.AGUILA_COMEX_be.entities.BLEntity;
import com.usach.AGUILA_COMEX_be.repositories.BLRepository;
import com.usach.AGUILA_COMEX_be.services.BLService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bl")
public class BLController {

    @Autowired
    private BLService blService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    private String save(@RequestBody BLEntity data){
        blService.create(data);
        return "funciona";
    }

    @GetMapping
    private List<BLEntity> findAllBL (){
        return blService.getAllBL();
    }

    @GetMapping("/{id}")
    private Optional<BLEntity> findBL (@PathVariable("id") Long id){
        return blService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/opid/{id}")
    private Optional<BLEntity> findByOpID (@PathVariable("id") int id){
        return blService.findByOpID(id);
    }

    @PutMapping("/{id}")
    private BLEntity updateBL(@RequestBody BLEntity blEntity, @PathVariable("id") Long id){
        return blService.update(blEntity, id);
    }

    @DeleteMapping("/{id}")
    private void deleteBL(@PathVariable("id") Long id){
        blService.delete(id);
    }

}
