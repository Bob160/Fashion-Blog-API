package com.fashion.fashionblogapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsLikesDto {
    private Long postsId;
    //private String commentId;
    private Long usersId;
}
