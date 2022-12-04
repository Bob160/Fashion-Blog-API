package com.fashion.fashionblogapi.repositories;

import com.fashion.fashionblogapi.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findCommentsByPostsId(Long postsId);
    Optional<Comments> findCommentsById(Long id);
    void deleteCommentsById(Long id);
}
