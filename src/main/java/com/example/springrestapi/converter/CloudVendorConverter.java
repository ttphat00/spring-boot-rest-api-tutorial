package com.example.springrestapi.converter;

import com.example.springrestapi.dto.CloudVendorDTO;
import com.example.springrestapi.entity.CloudVendorEntity;
import org.springframework.stereotype.Component;

@Component
public class CloudVendorConverter {

    public CloudVendorEntity toEntity(CloudVendorDTO dto){
        CloudVendorEntity entity = new CloudVendorEntity();
        entity.setVendorName(dto.getVendorName());
        entity.setVendorAddress(dto.getVendorAddress());
        entity.setVendorPhoneNumber(dto.getVendorPhoneNumber());
        return entity;
    }

    public CloudVendorDTO toDTO(CloudVendorEntity entity){
        CloudVendorDTO dto = new CloudVendorDTO();
        dto.setId(entity.getId());
        dto.setVendorName(entity.getVendorName());
        dto.setVendorAddress(entity.getVendorAddress());
        dto.setVendorPhoneNumber(entity.getVendorPhoneNumber());
        return dto;
    }

    public CloudVendorEntity toEntity(CloudVendorDTO dto, CloudVendorEntity entity){
        entity.setVendorName(dto.getVendorName());
        entity.setVendorAddress(dto.getVendorAddress());
        entity.setVendorPhoneNumber(dto.getVendorPhoneNumber());
        return entity;
    }
}
