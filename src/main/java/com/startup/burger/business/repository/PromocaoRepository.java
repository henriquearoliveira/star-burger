package com.startup.burger.business.repository;

import com.startup.burger.business.model.Promocao;
import com.startup.burger.business.model.enums.TipoRegra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

    List<Promocao> getByTipoRegra(TipoRegra muchMore);
}
