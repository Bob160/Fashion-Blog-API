package com.fashion.fashionblogapi.entities;

import com.fashion.fashionblogapi.enums.UserRoles;
import lombok.*;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;
    private String name;
    private String email;
    private String password;

    @Column(nullable = false)
    private String userRoles;

//    @OneToMany(mappedBy = "users")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Posts> postList;


}
