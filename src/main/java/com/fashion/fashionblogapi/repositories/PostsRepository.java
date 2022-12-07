package com.fashion.fashionblogapi.repositories;

import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
