package com.fashion.fashionblogapi.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postsLikesId;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

}
