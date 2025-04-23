package com.example.ioc.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
