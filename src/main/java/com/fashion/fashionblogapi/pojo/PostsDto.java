package com.fashion.fashionblogapi.pojo;

import com.fashion.fashionblogapi.enums.Designs;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDto {
    //private Long id;
    private String postTitle;
    private Designs designs;


}
