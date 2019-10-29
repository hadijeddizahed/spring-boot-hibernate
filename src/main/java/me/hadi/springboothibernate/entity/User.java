package me.hadi.springboothibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}
