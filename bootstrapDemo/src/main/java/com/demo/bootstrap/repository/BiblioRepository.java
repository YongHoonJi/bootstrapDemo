package com.demo.bootstrap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bootstrap.domain.Biblio;

// JpaRepository extends PagingAndSortingRepository , which in turn extends CrudRepository.
@Repository
public interface BiblioRepository extends JpaRepository<Biblio, String> {
}
