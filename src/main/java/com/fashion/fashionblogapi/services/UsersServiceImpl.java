package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.enums.UserRoles;
import com.fashion.fashionblogapi.pojo.UsersDto;
import com.fashion.fashionblogapi.repositories.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users userSignUp(UsersDto usersDto) {
        Users newUsers = new Users();
        if (UserRoles.ADMIN == null) {
            newUsers.setName(usersDto.getName());
            newUsers.setEmail(usersDto.getEmail());
            newUsers.setPassword(usersDto.getPassword());
            newUsers.setUserRoles(UserRoles.ADMIN);
            return usersRepository.save(newUsers);
        } else {
            newUsers.setName(usersDto.getName());
            newUsers.setEmail(usersDto.getEmail());
            newUsers.setPassword(usersDto.getPassword());
            newUsers.setUserRoles(usersDto.getUserRoles());
            return usersRepository.save(newUsers);
        }
//        if (newUsers.getName() == null)
//            throw new NameCannotBeEmptyException("Please enter your name");
//        else if (newUsers.getEmail() == null)
//            throw new NameCannotBeEmptyException("Email is required");
//        else if (newUsers.getPassword() == null)
//            throw new NameCannotBeEmptyException("Please enter a password");
//
//        boolean UserExist = usersRepository.findByEmail(newUsers.getEmail());
//        if(UserExist)
//            throw new UserAlreadyExistException("User already exists. Login instead");
//UserRoles userRoles;



    }

    @Override
    public UsersDto userLogin(String email, String password) {
        Users users = usersRepository.findByEmailAndPassword(email, password);
        if (users != null) {
            UsersDto usersDto = new UsersDto();
//            usersDto.setEmail(users.getEmail());
//            usersDto.setName(users.getName());
           BeanUtils.copyProperties(users, usersDto);
            System.out.println(usersDto);
            return usersDto;
        }
        throw new RuntimeException("User does not exist!");
    }
}
