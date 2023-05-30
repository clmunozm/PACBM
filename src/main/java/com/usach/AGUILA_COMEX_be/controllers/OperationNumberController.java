package com.usach.AGUILA_COMEX_be.controllers;

import com.usach.AGUILA_COMEX_be.services.OperationNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opid")
public class OperationNumberController {

    @Autowired
    OperationNumberService operationNumberService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    private Integer current (){
        return operationNumberService.retrieveCurrent();
    }
}
