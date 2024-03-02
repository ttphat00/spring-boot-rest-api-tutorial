package com.example.springrestapi.dto;

//import io.swagger.annotations.ApiModelProperty;

public abstract class BaseDTO {

//    @ApiModelProperty(notes = "This is a Cloud Vendor ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
