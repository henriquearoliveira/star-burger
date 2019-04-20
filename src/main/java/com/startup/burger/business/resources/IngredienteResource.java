package com.startup.burger.business.resources;

import com.startup.burger.business.model.Ingrediente;
import com.startup.burger.business.service.IngredienteService;
import com.startup.burger.comum.ResourceAbstract;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteResource extends ResourceAbstract<Ingrediente, IngredienteService> {
}
