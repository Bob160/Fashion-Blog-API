package com.fashion.fashionblogapi.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentsLikesId;

    @Column(nullable = false)
    private Long commentsId;

    @Column(nullable = false)
    private Long usersId;
}
