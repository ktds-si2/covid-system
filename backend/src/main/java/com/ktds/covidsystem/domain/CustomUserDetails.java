package com.ktds.covidsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Getter
@ToString
@Table(name = "user")
//@EntityListeners(AuditingEntityListener.class)
@Entity
@NoArgsConstructor
public class CustomUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Column(nullable = false, unique = true)
    private String password;
    private String authority;


//    @Column(nullable = false, insertable = false, updatable = false,
//            columnDefinition = "datetime default CURRENT_TIMESTAMP")
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column(nullable = false, insertable = false, updatable = false,
//            columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
//    @LastModifiedDate
//    private LocalDateTime modifiedAt;

    public CustomUserDetails(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }
}
