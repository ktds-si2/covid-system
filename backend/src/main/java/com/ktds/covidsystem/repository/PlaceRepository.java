package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Author : KJH
public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceRepositoryQSL {
    public Optional<Place> findById(Long id);
    public Optional<List<Place>> findAllByPlaceType(PlaceType placeType);
}
