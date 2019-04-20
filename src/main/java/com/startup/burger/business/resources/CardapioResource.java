package com.startup.burger.business.resources;

import com.startup.burger.business.model.Cardapio;
import com.startup.burger.business.service.CardapioService;
import com.startup.burger.comum.ResourceAbstract;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardapio")
public class CardapioResource extends ResourceAbstract<Cardapio, CardapioService> {
}
