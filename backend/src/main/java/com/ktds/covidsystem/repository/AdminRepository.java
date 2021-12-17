package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Author : KJH
public interface AdminRepository extends JpaRepository<Place, Long> {
}
