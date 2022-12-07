package com.fashion.fashionblogapi.controllers;

import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.pojo.UsersDto;
import com.fashion.fashionblogapi.pojo.UsersResponseDto;
import com.fashion.fashionblogapi.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.MarshalledObject;
import java.util.LinkedHashMap;
import java.util.Map;
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody UsersDto usersDto) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        usersService.userSignUp(usersDto);
        map.put("status", 1);
        map.put("message", "Signed up successfully!");
        map.put("user", usersDto);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UsersDto usersDto) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
       UsersDto usersDto1 = usersService.userLogin(usersDto.getEmail(), usersDto.getPassword());
        map.put("status", 1);
        map.put("message", "Login successful!");
        map.put("user", usersDto1);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
