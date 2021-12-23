package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

// Author : KJH
public interface FavoriteRepository extends JpaRepository<Favorite, Long>, FavoriteRepositoryQSL {
}
