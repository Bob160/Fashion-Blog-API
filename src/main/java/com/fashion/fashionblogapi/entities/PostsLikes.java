package com.fashion.fashionblogapi.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "post_likes")
@Getter
@Setter
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
