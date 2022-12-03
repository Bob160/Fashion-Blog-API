package com.fashion.fashionblogapi.entities;

import com.fashion.fashionblogapi.enums.Designs;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post_table")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String postTitle;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Designs designs;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "posts")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Comments> userComment;



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @PrePersist
    protected void setCreatedAt() {
        if (this.createdAt == null)
            createdAt = new Date();
        if (this.updatedAt == null)
            updatedAt = new Date();
        if (this.id == null);
        try {
            id = Long.parseLong(UUID.randomUUID().toString());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @PreUpdate
    protected void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Posts() {

    }

    public Posts(Long id, String postTitle, Designs designs, Date createdAt, Date updatedAt) {
        this.id = id;
        this.postTitle = postTitle;
        this.designs = designs;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Designs getDesigns() {
        return designs;
    }

    public void setDesigns(Designs designs) {
        this.designs = designs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", designs=" + designs +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", users=" + users +
                ", userComment=" + userComment +
                '}';
    }
}
