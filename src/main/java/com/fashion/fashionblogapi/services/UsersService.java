package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.pojo.UsersDto;

public interface UsersService {
    Users userSignUp(UsersDto usersDto);
    UsersDto userLogin(String email, String password);
}
