package com.startup.burger.business.resources;

import com.startup.burger.business.model.Promocao;
import com.startup.burger.business.model.dto.PromocaoDTO;
import com.startup.burger.business.service.PromocaoService;
import com.startup.burger.comum.ResourceAbstract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/promocoes")
public class PromocaoResource extends ResourceAbstract<Promocao, PromocaoService> {

    @PostMapping(value = "regras")
    public ResponseEntity<Promocao> create(@Valid @RequestBody PromocaoDTO promocaoDTO) {
        Promocao promocao = super.services.create(promocaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(promocao);
    }
}
