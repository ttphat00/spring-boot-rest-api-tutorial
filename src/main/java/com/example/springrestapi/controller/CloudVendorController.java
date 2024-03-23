package com.example.springrestapi.controller;

import com.example.springrestapi.dto.CloudVendorDTO;
import com.example.springrestapi.response.ResponseHandler;
import com.example.springrestapi.service.ICloudVendorService;
//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cloud-vendor")
public class CloudVendorController {

    private static final Logger logInfo = LoggerFactory.getLogger(CloudVendorController.class);
    private final ICloudVendorService cloudVendorService;

    public CloudVendorController(ICloudVendorService cloudVendorService){
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(value = "vendor-name", required = false) String name){
        List<CloudVendorDTO> data = cloudVendorService.getAll();
        String message = "Requested all Vendor are given here";
        if(name != null){
            data = cloudVendorService.getByVendorName(name);
            message = "Requested all Vendor-by-name are given here";
            logInfo.debug("Get all Cloud Vendor by name");
        }
        logInfo.info("Get all Cloud Vendor");
        return ResponseHandler.responseBuilder(
                message,
                HttpStatus.OK,
                data
        );
    }

    @GetMapping("/{id}")
//    @ApiOperation(value = "Cloud Vendor ID", notes = "Provide cloud vendor details", response = ResponseEntity.class)
    public ResponseEntity<Object> getOneById(@PathVariable("id") int id){
        return ResponseHandler.responseBuilder(
                "Requested Vendor Details are given here",
                HttpStatus.OK,
                cloudVendorService.getOne(id)
        );
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CloudVendorDTO cloudVendorDTO){
        return ResponseHandler.responseBuilder(
                "Created successfully",
                HttpStatus.CREATED,
                cloudVendorService.create(cloudVendorDTO)
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody CloudVendorDTO cloudVendorDTO){
        return ResponseHandler.responseBuilder(
                "Updated successfully",
                HttpStatus.OK,
                cloudVendorService.update(id, cloudVendorDTO)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        cloudVendorService.delete(id);
        return ResponseHandler.responseBuilder(
                "Deleted successfully",
                HttpStatus.OK,
                null
        );
    }
}
