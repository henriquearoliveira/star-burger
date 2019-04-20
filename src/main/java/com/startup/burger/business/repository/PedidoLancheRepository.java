package com.startup.burger.business.repository;

import com.startup.burger.business.model.PedidoLanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoLancheRepository extends JpaRepository<PedidoLanche, Long> {
}
