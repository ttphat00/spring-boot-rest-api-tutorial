package com.example.springrestapi.service.impl;

import com.example.springrestapi.converter.CloudVendorConverter;
import com.example.springrestapi.dto.CloudVendorDTO;
import com.example.springrestapi.entity.CloudVendorEntity;
import com.example.springrestapi.exception.CloudVendorNotFoundException;
import com.example.springrestapi.repository.CloudVendorRepository;
import com.example.springrestapi.service.ICloudVendorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloudVendorService implements ICloudVendorService {

    private final CloudVendorConverter converter;

    private final CloudVendorRepository cloudVendorRepository;

    public CloudVendorService(CloudVendorRepository cloudVendorRepository,
                              CloudVendorConverter converter){
        this.cloudVendorRepository = cloudVendorRepository;
        this.converter = converter;
    }

    @Override
    public CloudVendorDTO create(CloudVendorDTO cloudVendorDTO) {
        CloudVendorEntity cloudVendorEntity = converter.toEntity(cloudVendorDTO);
        cloudVendorEntity = cloudVendorRepository.save(cloudVendorEntity);
        CloudVendorDTO newCloudVendorDTO = converter.toDTO(cloudVendorEntity);
        return newCloudVendorDTO;
    }

    @Override
    public CloudVendorDTO update(int id, CloudVendorDTO cloudVendorDTO) {
        CloudVendorEntity oldEntity = cloudVendorRepository.findById(id).orElseThrow(
                () -> new CloudVendorNotFoundException("Requested Cloud Vendor does not exist")
        );
        CloudVendorEntity newEntity = converter.toEntity(cloudVendorDTO, oldEntity);
        newEntity = cloudVendorRepository.save(newEntity);
        CloudVendorDTO newDTO = converter.toDTO(newEntity);
        return newDTO;
    }

    @Override
    public void delete(int id) {
        try{
            cloudVendorRepository.deleteById(id);
        }catch (Exception e){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
    }

    @Override
    public CloudVendorDTO getOne(int id) {
        CloudVendorEntity entity = cloudVendorRepository.findById(id).orElseThrow(
                () -> new CloudVendorNotFoundException("Requested Cloud Vendor does not exist")
        );
        CloudVendorDTO dto = converter.toDTO(entity);
        return dto;
    }

    @Override
    public List<CloudVendorDTO> getAll() {
        List<CloudVendorEntity> entities = cloudVendorRepository.findAll();
        List<CloudVendorDTO> results = new ArrayList<>();
        entities.forEach((CloudVendorEntity entity) -> {
            CloudVendorDTO dto = converter.toDTO(entity);
            results.add(dto);
        });
        return results;
    }

    @Override
    public List<CloudVendorDTO> getByVendorName(String name) {
        List<CloudVendorEntity> entities = cloudVendorRepository.findByVendorName(name);
        List<CloudVendorDTO> results = new ArrayList<>();
        entities.forEach((CloudVendorEntity entity) -> {
            CloudVendorDTO dto = converter.toDTO(entity);
            results.add(dto);
        });
        return results;
    }
}
