package com.fashion.fashionblogapi.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsersDto {
    private String name;
    private String email;
    private String password;


}
