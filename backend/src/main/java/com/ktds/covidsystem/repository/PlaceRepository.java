package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

// Author : KJH
public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceRepositoryQSL {
}
