package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.ClienteEntity;
import com.usach.AGUILA_COMEX_be.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteEntity cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new ClienteEntity();
        cliente.setId(1L);
    }

    // HU 19: Crear un cliente en la plataforma
    @Test
    void create() {
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(cliente);
        assertNotNull(clienteService.create(new ClienteEntity()));
    }

    // HU 20: Visualizar los clientes registrados en la plataforma
    @Test
    void getAllClientes() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.getAllClientes());
    }

    // HU 20: Visualizar los clientes registrados en la plataforma
    @Test
    void findById() {
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(cliente));
        assertNotNull(clienteService.findById(anyLong()));
    }

    // H 21: Actualizar un cliente en la plataforma
    @Test
    void update() {

    }

    // HU 22: Eliminar un cliente en la plataforma
    @Test
    void delete() {
        willDoNothing().given(clienteRepository).deleteById(anyLong());
        clienteService.delete(cliente.getId());
        verify(clienteRepository,times(1)).deleteById(cliente.getId());
    }
}