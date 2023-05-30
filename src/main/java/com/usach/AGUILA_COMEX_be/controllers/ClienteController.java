package com.usach.AGUILA_COMEX_be.controllers;


import com.usach.AGUILA_COMEX_be.entities.ClienteEntity;
import com.usach.AGUILA_COMEX_be.services.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear cliente
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    private ClienteEntity saveCliente(@RequestBody ClienteEntity clienteEntity) {
        return clienteService.create(clienteEntity);
    }

    // Obtener todos los clientes
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
	private List<ClienteEntity> findAllClientes (){
		return clienteService.getAllClientes();
	}

    // Obtener cliente por id
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{id}")
	private Optional<ClienteEntity> findCliente (@PathVariable("id") Long id){
		return clienteService.findById(id);
	}

    // Modificar cliente por id
    @PutMapping("/{id}")
    private ClienteEntity updateCliente(@RequestBody ClienteEntity cliente, @PathVariable("id") Long id){
        return clienteService.update(cliente, id);
    }

    // Eliminar cliente por id
    @DeleteMapping("/{id}")
    private void deleteCliente(@PathVariable("id") Long id){
        clienteService.delete(id);
    }

}
