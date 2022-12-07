package com.fashion.fashionblogapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment_likes")
@Getter
@Setter
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
