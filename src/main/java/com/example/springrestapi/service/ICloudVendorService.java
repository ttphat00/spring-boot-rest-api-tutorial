package com.example.springrestapi.service;

import com.example.springrestapi.dto.CloudVendorDTO;

import java.util.List;

public interface ICloudVendorService {
    public CloudVendorDTO create(CloudVendorDTO cloudVendorDTO);
    public CloudVendorDTO update(long id, CloudVendorDTO cloudVendorDTO);
    public void delete(long id);
    public CloudVendorDTO getOne(long id);
    public List<CloudVendorDTO> getAll();

    List<CloudVendorDTO> getByVendorName(String name);
}
