package com.zh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "menu entity")
public class Menu {
    @ApiModelProperty(value = "primary key")
    private int id;
    @ApiModelProperty(value = "menu name")
    private String name;

}
