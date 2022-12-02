package com.fashion.fashionblogapi.pojo;

import com.fashion.fashionblogapi.enums.Designs;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class PostsDto {
    private Long id;
    private String name;
    private Designs designs;
    private Date createdAt;
    private Date updatedAt;


}
