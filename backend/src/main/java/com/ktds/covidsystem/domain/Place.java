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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlaceType placeType;    // 장소유형

    @Setter
    @Column(nullable = false)
    private String placeName;       // 이름

    @Setter
    @Column(nullable = false)
    private String address;         // 주소

    @Setter
    @Column(nullable = false)
    private String phoneNumber;     // 번호

    @Setter
    @Column(nullable = false)
    private Integer currentNumberOfPeople;  // 현재 인원

    @Setter
    @Column(nullable = false)
    private Integer capacity;       // 수용가능인원


    @Setter
    private String memo;            // 메모


    @Column(nullable = false, insertable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;    // 생성 날짜

    @Column(nullable = false, insertable = false, updatable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;   // 수정 날짜


    protected Place() {
    }

    protected Place(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static Place of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new Place(placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo);
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
