package com.fashion.fashionblogapi.entities;

import com.fashion.fashionblogapi.enums.UserRoles;
import lombok.*;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "users_table")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;

    @OneToMany(mappedBy = "users")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Posts> postList;


}
