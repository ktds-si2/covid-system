package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Author : JHW
@Repository
public interface UserRepository extends JpaRepository<CustomUserDetails, Long> {

    CustomUserDetails findByUsername(String username);

}
