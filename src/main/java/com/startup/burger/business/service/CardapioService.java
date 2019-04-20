package com.startup.burger.business.service;

import com.startup.burger.business.model.Cardapio;
import com.startup.burger.business.repository.CardapioRepository;
import com.startup.burger.comum.ServiceAbstract;
import org.springframework.stereotype.Service;

@Service
public class CardapioService extends ServiceAbstract<Cardapio, CardapioRepository> {
}
