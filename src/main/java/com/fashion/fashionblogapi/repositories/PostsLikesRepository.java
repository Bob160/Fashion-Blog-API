package com.fashion.fashionblogapi.repositories;


import com.fashion.fashionblogapi.entities.PostsLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsLikesRepository extends JpaRepository<PostsLikes, Long> {
//    List<PostLikes> findLikesByCommentId(Long commentsId);
//    List<PostLikes> findLikesByPostsId(Long postsId);
//    void deleteLikesByCommentsId(Long commentsId);
//    void deleteLikesByPostsId(Long postsId);


    Optional<PostsLikes> findByUserIdAndPostId(Long userId, Long postId);

}
