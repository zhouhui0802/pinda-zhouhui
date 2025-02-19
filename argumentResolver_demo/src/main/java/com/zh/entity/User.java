package com.zh.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor

public class User implements Serializable {

    private Long id;
    private String username;
}
