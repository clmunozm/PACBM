package com.usach.AGUILA_COMEX_be.controllers;

import com.usach.AGUILA_COMEX_be.entities.PortsEntity;
import com.usach.AGUILA_COMEX_be.services.PortsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ports")
public class PortsController {

    @Autowired
    private PortsService portsService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    private PortsEntity save(@RequestBody PortsEntity data){
        return portsService.create(data);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    private List<PortsEntity> findAllPorts (){
        return portsService.getAllPorts();
    }

    @GetMapping("/{id}")
    private Optional<PortsEntity> findPort(@PathVariable("id") Long id){
        return portsService.findById(id);
    }

    @PutMapping("/{id}")
    private PortsEntity updatePort(@RequestBody PortsEntity portsEntity, @PathVariable("id") Long id){
        return portsService.update(portsEntity, id);
    }

    @DeleteMapping("/{id}")
    private void deletePort(@PathVariable("id") Long id){
        portsService.delete(id);
    }
}
