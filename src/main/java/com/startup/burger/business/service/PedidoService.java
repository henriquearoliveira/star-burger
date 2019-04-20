package com.startup.burger.business.service;

import com.startup.burger.business.model.*;
import com.startup.burger.business.model.dto.PedidoDTO;
import com.startup.burger.business.repository.PedidoRepository;
import com.startup.burger.comum.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService extends ServiceAbstract<Pedido, PedidoRepository> {

    @Autowired
    private LightPromocao lightPromocao;

    @Autowired
    private MuchPromocao muchPromocao;

    public Pedido create(PedidoDTO pedidoDTO) {

        Pedido pedido = new Pedido();
        pedido.setDescricao(pedidoDTO.getDescricao());
        pedido.setUsuario(pedidoDTO.getUsuario());
        List<PedidoLanche> pedidoLanches = new ArrayList<>();

        pedidoDTO.getLanches().forEach(lanche -> {

            BigDecimal descontoInNotIn, descontoMuchMore;

            PedidoLanche pedidoLanche = new PedidoLanche();
            pedidoLanche.setPedido(pedido);
            pedidoLanche.setLanche(lanche);

            BigDecimal total = lanche.getIngredientes().stream()
                    .map(ingrediente -> ingrediente.getValor()
                            .multiply(new BigDecimal(String.valueOf(ingrediente.getQuantidade() == 0 ? 1 : ingrediente.getQuantidade()))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            descontoInNotIn = lightPromocao.calcDescontoPromocao(lanche.getIngredientes());
            descontoMuchMore = muchPromocao.calcDescontoPromocao(lanche.getIngredientes());

            pedidoLanche.setDesconto(descontoInNotIn.add(descontoMuchMore)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
            pedidoLanche.setTotal(total.subtract(descontoInNotIn).subtract(descontoMuchMore));

            createPedidoLancheIngrediente(pedidoLanche, lanche.getIngredientes());

            pedidoLanches.add(pedidoLanche);

        });

        pedido.setPedidoLanches(pedidoLanches);
        super.insere(pedido);
        return pedido;
    }

    private void createPedidoLancheIngrediente(PedidoLanche pedidoLanche, List<Ingrediente> ingredientes) {

        List<PedidoLancheIngrediente> pedidoLancheIngredientes = new ArrayList<>();

        ingredientes.forEach(ingrediente -> {
            PedidoLancheIngrediente pedidoLancheIngrediente = new PedidoLancheIngrediente();

            pedidoLancheIngrediente.setPedidoLanche(pedidoLanche);
            pedidoLancheIngrediente.setIngrediente(ingrediente);
            pedidoLancheIngrediente.setQuantidade(ingrediente.getQuantidade());
            pedidoLancheIngrediente.setValor(ingrediente.getValor());

            pedidoLancheIngredientes.add(pedidoLancheIngrediente);
        });

        pedidoLanche.setPedidoLancheIngredientes(pedidoLancheIngredientes);
    }

}
