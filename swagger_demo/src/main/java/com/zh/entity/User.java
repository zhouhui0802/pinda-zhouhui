package com.zh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "user entity")
public class User {

    @ApiModelProperty(value = "primary key")
    private int id;
    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "age")
    private int age;
    @ApiModelProperty(value = "address")
    private String address;
}
