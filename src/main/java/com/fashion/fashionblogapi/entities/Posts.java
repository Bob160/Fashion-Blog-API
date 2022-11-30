package com.fashion.fashionblogapi.entities;

import com.fashion.fashionblogapi.enums.Designs;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String postBody;

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

    public Posts(Long id, String postBody, Designs designs, Date createdAt, Date updatedAt) {
        this.id = id;
        this.postBody = postBody;
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

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
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
                ", postBody='" + postBody + '\'' +
                ", designs=" + designs +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", users=" + users +
                '}';
    }
}
