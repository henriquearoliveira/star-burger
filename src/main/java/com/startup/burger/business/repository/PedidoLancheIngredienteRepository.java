package com.startup.burger.business.repository;

import com.startup.burger.business.model.PedidoLancheIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoLancheIngredienteRepository extends JpaRepository<PedidoLancheIngrediente, Long> {
}
