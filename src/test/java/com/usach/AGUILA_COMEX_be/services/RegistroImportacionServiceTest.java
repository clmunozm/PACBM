package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.RegistroImportacionEntity;
import com.usach.AGUILA_COMEX_be.repositories.RegistroImportacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RegistroImportacionServiceTest {

    @Mock
    private RegistroImportacionRepository registroImportacionRepository;

    @InjectMocks
    private RegistroImportacionService registroImportacionService;

    private RegistroImportacionEntity registroImportacion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registroImportacion = new RegistroImportacionEntity();
        registroImportacion.setId(1L);
    }

    @Test
    void create() {
        when(registroImportacionRepository.save(any(RegistroImportacionEntity.class))).thenReturn(registroImportacion);
        assertNotNull(registroImportacionService.create(new RegistroImportacionEntity()));
    }

    @Test
    void getAllRegImp() {
        when(registroImportacionRepository.findAll()).thenReturn(Arrays.asList(registroImportacion));
        assertNotNull(registroImportacionService.getAllRegImp());
    }

    @Test
    void findById() {
        when(registroImportacionRepository.findById(anyLong())).thenReturn(Optional.ofNullable(registroImportacion));
        assertNotNull(registroImportacionService.findById(anyLong()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        willDoNothing().given(registroImportacionRepository).deleteById(anyLong());
        registroImportacionService.delete(registroImportacion.getId());
        verify(registroImportacionRepository,times(1)).deleteById(registroImportacion.getId());
    }
}