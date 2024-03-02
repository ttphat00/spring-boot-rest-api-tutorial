package com.example.springrestapi.repository;

import com.example.springrestapi.entity.CloudVendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendorEntity, Long> {
    List<CloudVendorEntity> findByVendorName(String name);
//    CloudVendorEntity findByVendorName(String name); //Return unique value in db. If value in db > 1 => Error
}
