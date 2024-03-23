package com.example.springrestapi.service.impl;

import com.example.springrestapi.converter.CloudVendorConverter;
import com.example.springrestapi.dto.CloudVendorDTO;
import com.example.springrestapi.entity.CloudVendorEntity;
import com.example.springrestapi.repository.CloudVendorRepository;
import com.example.springrestapi.service.ICloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CloudVendorServiceTest {
    @Mock
    private CloudVendorRepository cloudVendorRepository;
    @Mock
    private CloudVendorConverter converter;
    private ICloudVendorService cloudVendorService;
    CloudVendorEntity cloudVendorEntity;
    CloudVendorEntity savedCloudVendorEntity;
    CloudVendorDTO cloudVendorDTO;
    CloudVendorDTO newCloudVendorDTO;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorService(cloudVendorRepository, converter);
        cloudVendorEntity = new CloudVendorEntity("Amazon",
                "USA", "xxxxx");
        savedCloudVendorEntity = new CloudVendorEntity(1, "Amazon",
                "USA", "xxxxx");
        cloudVendorDTO = new CloudVendorDTO("Amazon",
                "USA", "xxxxx");
        newCloudVendorDTO = new CloudVendorDTO(1, "Amazon",
                "USA", "xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreate(){
        when(converter.toEntity(cloudVendorDTO)).thenReturn(cloudVendorEntity);
        when(cloudVendorRepository.save(cloudVendorEntity)).thenReturn(savedCloudVendorEntity);
        when(converter.toDTO(savedCloudVendorEntity)).thenReturn(newCloudVendorDTO);

        assertThat(cloudVendorService.create(cloudVendorDTO).getId())
                .isEqualTo(newCloudVendorDTO.getId());
        assertThat(cloudVendorService.create(cloudVendorDTO).getVendorName())
                .isEqualTo(newCloudVendorDTO.getVendorName());
    }

    @Test
    void testUpdate(){
        when(converter.toEntity(cloudVendorDTO, savedCloudVendorEntity)).thenReturn(savedCloudVendorEntity);
        when(cloudVendorRepository.findById(1)).thenReturn(Optional.ofNullable(savedCloudVendorEntity));
        when(cloudVendorRepository.save(savedCloudVendorEntity)).thenReturn(savedCloudVendorEntity);
        when(converter.toDTO(savedCloudVendorEntity)).thenReturn(newCloudVendorDTO);

        assertThat(cloudVendorService.update(1, cloudVendorDTO).getId())
                .isEqualTo(newCloudVendorDTO.getId());
        assertThat(cloudVendorService.update(1, cloudVendorDTO).getVendorName())
                .isEqualTo(newCloudVendorDTO.getVendorName());
    }

    @Test
    void testDelete(){
        doNothing().when(cloudVendorRepository).deleteById(any());

        cloudVendorService.delete(1);
    }

    @Test
    void testGetOne(){
        when(cloudVendorRepository.findById(1)).thenReturn(Optional.ofNullable(savedCloudVendorEntity));
        when(converter.toDTO(savedCloudVendorEntity)).thenReturn(newCloudVendorDTO);

        assertThat(cloudVendorService.getOne(1).getId())
                .isEqualTo(newCloudVendorDTO.getId());
        assertThat(cloudVendorService.getOne(1).getVendorName())
                .isEqualTo(newCloudVendorDTO.getVendorName());
    }

    @Test
    void testGetAll(){
        when(cloudVendorRepository.findAll())
                .thenReturn(new ArrayList<CloudVendorEntity>(Collections.singleton(savedCloudVendorEntity)));
        when(converter.toDTO(savedCloudVendorEntity)).thenReturn(newCloudVendorDTO);

        assertThat(cloudVendorService.getAll().get(0).getId())
                .isEqualTo(newCloudVendorDTO.getId());
        assertThat(cloudVendorService.getAll().get(0).getVendorAddress())
                .isEqualTo(newCloudVendorDTO.getVendorAddress());
    }

    @Test
    void testGetByVendorName(){
        when(cloudVendorRepository.findByVendorName("Amazon"))
                .thenReturn(new ArrayList<CloudVendorEntity>(Collections.singleton(savedCloudVendorEntity)));
        when(converter.toDTO(savedCloudVendorEntity)).thenReturn(newCloudVendorDTO);

        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getId())
                .isEqualTo(newCloudVendorDTO.getId());
        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorPhoneNumber())
                .isEqualTo(newCloudVendorDTO.getVendorPhoneNumber());
    }
}
