package com.fashion.fashionblogapi.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class CommentsDto {
    private Long id;
    private String comments;
    private Date createdAt;
    private Date updatedAt;
    private String postId;
}
