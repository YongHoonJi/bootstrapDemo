package com.demo.bootstrap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bootstrap.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
