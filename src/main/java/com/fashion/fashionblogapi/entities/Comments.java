package com.fashion.fashionblogapi.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 50, nullable = true)
    private String comments;

//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Posts posts;

//    @OneToMany// (mappedBy = "comment")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<CommentsLikes> commentsLikes;

}
