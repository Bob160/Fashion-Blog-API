package com.fashion.fashionblogapi.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LikesDto {
    private Long id;
    private String commentId;
    private String postsId;

}
