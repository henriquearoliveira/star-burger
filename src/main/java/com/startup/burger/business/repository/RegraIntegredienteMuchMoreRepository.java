package com.startup.burger.business.repository;

import com.startup.burger.business.model.RegraIngredienteMuchMore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraIntegredienteMuchMoreRepository extends JpaRepository<RegraIngredienteMuchMore, Long> {
}
