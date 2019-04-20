package com.startup.burger.business.service;

import com.startup.burger.business.model.Ingrediente;
import com.startup.burger.business.model.Promocao;
import com.startup.burger.business.model.RegraIngredienteInNotIn;
import com.startup.burger.business.model.RegraIngredienteMuchMore;
import com.startup.burger.business.model.enums.TipoRegra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LightPromocao implements IPromocao {

    private PromocaoService promocaoService;
    private IngredienteService ingredienteService;
    private BigDecimal desconto = new BigDecimal("0");

    @Autowired
    public LightPromocao(PromocaoService promocaoService, IngredienteService ingredienteService) {
        this.promocaoService = promocaoService;
        this.ingredienteService = ingredienteService;
    }

    @Override
    public BigDecimal calcDescontoPromocao(List<Ingrediente> ingredientes) {

        List<Promocao> promocoes = promocaoService.getPromocaoBy(TipoRegra.IN_NOT_IN);
        List<RegraIngredienteInNotIn> regras = promocoes.stream()
                .flatMap(pro -> pro.getRegraIngredienteInNotInList().stream())
                .collect(Collectors.toList());

        // TODO
        regras.forEach(re -> {

            BigDecimal percent = (ingredientes.contains(re.getIngredienteIn()) && !ingredientes.contains(re.getIngredienteNotIn()))
                    ? re.getPorcentagemDesconto() : new BigDecimal("0");

            BigDecimal total = new BigDecimal("0");

            if (percent.intValue() > 0) {
                total = ingredientes.stream()
                        .map(ingrediente -> ingrediente.getValor()
                                .multiply(new BigDecimal(String.valueOf(ingrediente.getQuantidade() == 0 ? 1 : ingrediente.getQuantidade()))))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            desconto = desconto.add(total.multiply(percent));

        });

        return desconto;
    }

    public BigDecimal verificaPromocao(List<Ingrediente> ingredientes) {

        Ingrediente ingredienteAlface = ingredienteService.get(1l);
        Ingrediente ingredienteBacon = ingredienteService.get(2l);

        boolean containsPromotion = ingredientes.stream().anyMatch(ingrediente -> ingrediente.getId().equals(ingredienteAlface.getId())
                && ingrediente.getId().equals(ingredienteBacon.getId()));

        BigDecimal total = new BigDecimal("0");

        if (containsPromotion) {
            total = ingredientes.stream()
                    .map(ingrediente -> ingrediente.getValor()
                            .multiply(new BigDecimal(String.valueOf(ingrediente.getQuantidade() == 0 ? 1 : ingrediente.getQuantidade()))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return total.multiply(new BigDecimal("0.10"));
    }
}
