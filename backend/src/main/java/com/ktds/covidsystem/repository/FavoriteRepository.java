package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.FavoriteResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Author : KJH
public interface FavoriteRepository extends JpaRepository<Favorite, Long>, FavoriteRepositoryQSL {
    public List<Favorite> findByUserName(String userName);
}
