package com.example.springrestapi.service;

import com.example.springrestapi.dto.CloudVendorDTO;

import java.util.List;

public interface ICloudVendorService {
    public CloudVendorDTO create(CloudVendorDTO cloudVendorDTO);
    public CloudVendorDTO update(int id, CloudVendorDTO cloudVendorDTO);
    public void delete(int id);
    public CloudVendorDTO getOne(int id);
    public List<CloudVendorDTO> getAll();

    List<CloudVendorDTO> getByVendorName(String name);
}
