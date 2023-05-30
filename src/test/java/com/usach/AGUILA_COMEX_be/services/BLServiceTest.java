package com.usach.AGUILA_COMEX_be.services;

import com.usach.AGUILA_COMEX_be.entities.BLEntity;
import com.usach.AGUILA_COMEX_be.repositories.BLRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BLServiceTest {

    @Mock
    private BLRepository blRepository;

    @InjectMocks
    private BLService blService;

    private BLEntity bl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bl = new BLEntity();
        bl.setId(1L);
    }

    // HU 04: Crear una nueva operación en la plataforma
    @Test
    void create() {
        when(blRepository.save(new BLEntity())).thenReturn(bl);
        assertNotNull(blService.create(new BLEntity()));
    }

    // HU 13: Visualizar operaciones de la plataforma
    @Test
    void getAllBL() {
        when(blRepository.findAll()).thenReturn(Arrays.asList(bl));
        assertNotNull(blService.getAllBL());
    }

    // HU 13: Visualizar operaciones de la plataforma
    @Test
    void findById() {
        when(blRepository.findById(anyLong())).thenReturn(Optional.ofNullable(bl));
        assertNotNull(blService.findById(anyLong()));
    }

    // HU 11: Modificar una operación en la plataforma
    @Test
    void update() {

    }

    // HU 12: Eliminar una operación en la plataforma
    @Test
    void delete() {
        willDoNothing().given(blRepository).deleteById(anyLong());
        blService.delete(bl.getId());
        verify(blRepository,times(1)).deleteById(bl.getId());
    }
}