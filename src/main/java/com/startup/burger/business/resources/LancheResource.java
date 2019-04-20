package com.startup.burger.business.resources;

import com.startup.burger.business.model.Lanche;
import com.startup.burger.business.service.LancheService;
import com.startup.burger.comum.ResourceAbstract;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lanches")
public class LancheResource extends ResourceAbstract<Lanche, LancheService> {
}
