package com.example.springrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cloud_vendor")
public class CloudVendorEntity extends BaseEntity {

    @Column(name = "vendor_name")
    private String vendorName;
//    @Column(name = "vendor_address")
    private String vendorAddress;
//    @Column(name = "")
    private String vendorPhoneNumber;

    public CloudVendorEntity() {
    }

    public CloudVendorEntity(String vendorName, String vendorAddress, String vendorPhoneNumber) {
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public CloudVendorEntity(Integer id, String vendorName, String vendorAddress, String vendorPhoneNumber) {
        super(id);
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }
}
