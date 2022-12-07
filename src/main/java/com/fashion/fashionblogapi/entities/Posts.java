package com.fashion.fashionblogapi.entities;

import com.fashion.fashionblogapi.enums.Designs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 50, nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String designs;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId", nullable = false)
//    private Users users;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comments> userComment;

}
