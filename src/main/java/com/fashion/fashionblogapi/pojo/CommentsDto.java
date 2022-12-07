package com.fashion.fashionblogapi.pojo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Long commentId;
    private String comments;
    private Date createdAt;
    //private Date updatedAt;
    private Long postId;
}
