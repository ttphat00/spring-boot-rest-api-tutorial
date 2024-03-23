package com.example.springrestapi.dto;

//import io.swagger.annotations.ApiModel;

//@ApiModel(description = "This table holds cloud vendor information")
public class CloudVendorDTO extends BaseDTO {
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;

    public CloudVendorDTO() {
    }

    public CloudVendorDTO(String vendorName, String vendorAddress, String vendorPhoneNumber) {
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public CloudVendorDTO(Integer id, String vendorName, String vendorAddress, String vendorPhoneNumber) {
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
