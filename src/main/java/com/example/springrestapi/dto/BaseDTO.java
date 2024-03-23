package com.example.springrestapi.dto;

//import io.swagger.annotations.ApiModelProperty;

public abstract class BaseDTO {

//    @ApiModelProperty(notes = "This is a Cloud Vendor ID")
    private Integer id;

    public BaseDTO() {
    }

    public BaseDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
