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
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts_table")

public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 50, nullable = true)
    private String postTitle;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Designs designs;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> userComment;



    @Override
    public String toString() {
        return "Posts{" +
                "id=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", designs=" + designs +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", users=" + users +
                ", userComment=" + userComment +
                '}';
    }
}
