package com.fashion.fashionblogapi.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsLikesDto {
    private Long likesId;
    private String commentsId;
    private Long postsId;

}
