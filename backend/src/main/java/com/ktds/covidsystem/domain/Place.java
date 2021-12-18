package com.ktds.covidsystem.domain;

import com.ktds.covidsystem.constant.PlaceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    @Setter
    @Column(nullable = false)
    private String placeName;

    @Setter
    @Column(nullable = false)
    private String address;

    @Setter
    @Column(nullable = false)
    private String phoneNumber;

    @Setter
    @Column(nullable = false)
    private Integer currentNumberOfPeople;

    @Setter
    @Column(nullable = false)
    private Integer capacity;


    @Setter
    private String memo;

    @Column(nullable = false, insertable = false, updatable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false, updatable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime modifiedAt;


    protected Place() {
    }

    protected Place(
            PlaceType placeType,
            User user,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        this.placeType = placeType;
        this.user = user;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static Place of(
            PlaceType placeType,
            User user,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new Place(placeType, user, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return id != null && id.equals(((Place) obj).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeName, address, phoneNumber, createdAt, modifiedAt);
    }

}
