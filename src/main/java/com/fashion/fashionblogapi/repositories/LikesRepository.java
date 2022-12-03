package com.fashion.fashionblogapi.repositories;


import com.fashion.fashionblogapi.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findLikesByCommentsId(Long commentsId);
    List<Likes> findLikesByPostsId(Long postsId);
    void deleteLikesByCommentsId(Long commentsId);
    void deleteLikesByPostsId(Long postsId);




}
