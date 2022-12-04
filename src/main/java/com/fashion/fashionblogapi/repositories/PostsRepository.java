package com.fashion.fashionblogapi.repositories;

import com.fashion.fashionblogapi.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findPostsByUsersId(Long id);
    Optional<Posts> findPostsById(Long postsId);
    void deletePostsById(Long postsId);

}
