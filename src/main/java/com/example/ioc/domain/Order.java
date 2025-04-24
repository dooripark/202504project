package com.example.ioc.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders") // ✅ 테이블명 변경!
@Getter @Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
