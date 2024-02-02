package com.example.prueba.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//import lombok.Data;
//import lombok.Setter;

@Entity
@Data
@Table(name = "user_2")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(length = 50, nullable = false, unique = true)
    private String nickName;

    //    @Column(length = 50, nullable = false)
    private String password;

    //    @Column(nullable = false)
    private String email;


}
