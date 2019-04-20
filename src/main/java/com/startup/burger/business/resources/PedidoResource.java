package com.startup.burger.business.resources;

import com.startup.burger.business.model.Pedido;
import com.startup.burger.business.model.dto.PedidoDTO;
import com.startup.burger.business.service.PedidoService;
import com.startup.burger.comum.ResourceAbstract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource extends ResourceAbstract<Pedido, PedidoService> {

    @PostMapping(value = "lanches")
    public ResponseEntity<Pedido> create(@Valid @RequestBody PedidoDTO pedidoDTO) {

        pedidoDTO.setUsuario(getAutenticacao());
        Pedido pedido = super.services.create(pedidoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
