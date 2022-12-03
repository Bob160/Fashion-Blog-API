package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Users;
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

        newUsers.setName(usersDto.getName());
        newUsers.setEmail(usersDto.getEmail());
        newUsers.setPassword(usersDto.getPassword());

        return usersRepository.save(newUsers);
    }

    @Override
    public Users userLogin(String email, String password) {
        Users users = usersRepository.findByEmailAndPassword(email, password);
        if (users != null) {
            UsersDto usersDto = new UsersDto();
            BeanUtils.copyProperties(users, usersDto);
            return users;
        }
        throw new RuntimeException("User does not exist!");
    }
}
