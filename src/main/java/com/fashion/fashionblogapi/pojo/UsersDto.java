package com.fashion.fashionblogapi.pojo;

import com.fashion.fashionblogapi.enums.UserRoles;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String name;
    private String email;
    private String password;
    private UserRoles userRoles;


}
