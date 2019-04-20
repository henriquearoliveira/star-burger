package com.startup.burger.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraIngredienteInNotInRepository extends JpaRepository<com.startup.burger.business.model.RegraIngredienteInNotIn, Long> {
}
