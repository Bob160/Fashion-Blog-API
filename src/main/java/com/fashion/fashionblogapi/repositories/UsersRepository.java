package com.fashion.fashionblogapi.repositories;

import com.fashion.fashionblogapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    boolean findByEmail(String email);
    boolean findByName(String name);
    Users findByEmailAndPassword(String email, String password);
}
