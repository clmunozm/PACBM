package com.usach.AGUILA_COMEX_be.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usach.AGUILA_COMEX_be.entities.ClienteEntity;
import com.usach.AGUILA_COMEX_be.repositories.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteEntity create (ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public List<ClienteEntity> getAllClientes (){
		return clienteRepository.findAll();
	}

	@Transactional
	public Optional<ClienteEntity> findById (Long id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public ClienteEntity update (ClienteEntity cliente, Long id) {
		Optional<ClienteEntity> checkExistingCliente = findById(id);
        if (!checkExistingCliente.isPresent())
            throw new RuntimeException("Cliente Id "+ id + " Not Found!");
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}
	
	public void delete (Long id) {
		clienteRepository.deleteById(id);
	}

}
