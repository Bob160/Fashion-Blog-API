package com.fashion.fashionblogapi.pojo;

import com.fashion.fashionblogapi.enums.UserRoles;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsersResponseDto {
    private Long id;
    private String name;
    private String email;
    private UserRoles userRoles;
}
