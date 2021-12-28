package com.ktds.covidsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ktds.covidsystem.constant.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    public Member(String email, String password, Authority authority, boolean activated) {
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.activated = activated;
    }

}
