package com.example.ioc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String username;

    public MemberDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
