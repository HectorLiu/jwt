package com.hector.jwt.model;

import com.hector.jwt.shiro.core.Authenticatable;
import lombok.Data;

@Data
public class User extends Authenticatable {
    private Long id;
    private String name;
    private Integer age;
}
