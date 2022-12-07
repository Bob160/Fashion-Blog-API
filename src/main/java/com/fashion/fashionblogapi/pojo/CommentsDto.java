package com.fashion.fashionblogapi.pojo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private String comments;
    private Long postId;
}
