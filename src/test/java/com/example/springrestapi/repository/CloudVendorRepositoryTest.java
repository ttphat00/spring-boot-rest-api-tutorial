package com.example.springrestapi.repository;

import com.example.springrestapi.entity.CloudVendorEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendorEntity cloudVendorEntity;

    @BeforeEach
    void setUp() {
        cloudVendorEntity = new CloudVendorEntity("Amazon", "USA", "xxxxx");
        cloudVendorRepository.save(cloudVendorEntity);
    }

    @AfterEach
    void tearDown() {
        cloudVendorEntity = null;
        cloudVendorRepository.deleteAll();
    }

    //Test case Success
    @Test
    void testFindByVendorName_Found(){
        List<CloudVendorEntity> cloudVendorEntities = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorEntities.get(0).getId()).isEqualTo(cloudVendorEntity.getId());
        assertThat(cloudVendorEntities.get(0).getVendorAddress()).isEqualTo(cloudVendorEntity.getVendorAddress());
    }

    //Test case Failure
    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendorEntity> cloudVendorEntities = cloudVendorRepository.findByVendorName("GCP");
        assertThat(cloudVendorEntities.isEmpty()).isTrue();
    }
}
