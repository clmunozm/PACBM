package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.RegistroExportacionEntity;
import com.usach.AGUILA_COMEX_be.entities.RegistroImportacionEntity;
import com.usach.AGUILA_COMEX_be.repositories.RegistroExportacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

class RegistroExportacionServiceTest {

    @Mock
    private RegistroExportacionRepository registroExportacionRepository;

    @InjectMocks
    private RegistroExportacionService registroExportacionService;

    private RegistroExportacionEntity registroExportacion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registroExportacion = new RegistroExportacionEntity();
        registroExportacion.setId(1L);
    }

    @Test
    void create() {
        when(registroExportacionRepository.save(any(RegistroExportacionEntity.class))).thenReturn(registroExportacion);
        assertNotNull(registroExportacionService.create(new RegistroExportacionEntity()));
    }

    @Test
    void getAllRegExp() {
        when(registroExportacionRepository.findAll()).thenReturn(Arrays.asList(registroExportacion));
        assertNotNull(registroExportacionService.getAllRegExp());
    }

    @Test
    void findById() {
        when(registroExportacionRepository.findById(anyLong())).thenReturn(Optional.ofNullable(registroExportacion));
        assertNotNull(registroExportacionService.findById(anyLong()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        willDoNothing().given(registroExportacionRepository).deleteById(anyLong());
        registroExportacionService.delete(registroExportacion.getId());
        verify(registroExportacionRepository,times(1)).deleteById(registroExportacion.getId());
    }
}