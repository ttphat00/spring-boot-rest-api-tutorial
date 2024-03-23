package com.example.springrestapi.controller;

import com.example.springrestapi.dto.CloudVendorDTO;
import com.example.springrestapi.service.ICloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ICloudVendorService cloudVendorService;
    CloudVendorDTO cloudVendorOne;
    CloudVendorDTO cloudVendorTwo;
    List<CloudVendorDTO> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendorDTO(1, "Amazon", "USA", "xxxxx");
        cloudVendorTwo = new CloudVendorDTO(2, "Amazon", "UK", "yyyyy");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetOneById() throws Exception {
        when(cloudVendorService.getOne(1)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/api/cloud-vendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAll() throws Exception {
        when(cloudVendorService.getAll()).thenReturn(cloudVendorList);
        //when(cloudVendorService.getByVendorName("Amazon")).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/api/cloud-vendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllByVendorName() throws Exception {
        when(cloudVendorService.getAll()).thenReturn(cloudVendorList);
        when(cloudVendorService.getByVendorName("Amazon")).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/api/cloud-vendor?vendor-name=Amazon")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(cloudVendorService).delete(anyInt());
        this.mockMvc.perform(delete("/api/cloud-vendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.create(cloudVendorOne)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(post("/api/cloud-vendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdate() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.update(1, cloudVendorOne)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(put("/api/cloud-vendor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
