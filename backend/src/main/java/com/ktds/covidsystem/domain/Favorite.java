package com.ktds.covidsystem.domain;

import com.ktds.covidsystem.dto.FavoriteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Table(name = "favorite")
@Entity
@NoArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    private Place place;

    @Setter
    private String userName;

    public Favorite(Place place, String userName) {
        this.place = place;
        this.userName = userName;
    }

    public static Favorite of(Place place, String userName) {
        return new Favorite(place, userName);
    }

}
