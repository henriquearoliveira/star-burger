package com.startup.burger.business.service;

import com.startup.burger.business.model.Ingrediente;
import com.startup.burger.business.model.Promocao;
import com.startup.burger.business.model.RegraIngredienteMuchMore;
import com.startup.burger.business.model.enums.TipoRegra;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuchPromocao implements IPromocao {

    private final PromocaoService promocaoService;
    private final IngredienteService ingredienteService;

    public MuchPromocao(PromocaoService promocaoService, IngredienteService ingredienteService) {
        this.promocaoService = promocaoService;
        this.ingredienteService = ingredienteService;
    }

    private BigDecimal desconto = new BigDecimal("0");

    @Override
    public BigDecimal calcDescontoPromocao(List<Ingrediente> ingredientes) {

        List<Promocao> promocoes = promocaoService.getPromocaoBy(TipoRegra.MUCH_MORE);
        List<Ingrediente> ingredientesPromo = promocoes.stream()
                .flatMap(pro -> pro.getRegraIngredienteMuchMoreList().stream())
                .map(RegraIngredienteMuchMore::getIngrediente)
                .collect(Collectors.toList());

        ingredientesPromo.forEach(inP -> {
            ingredientes.forEach(ing -> {
                if (inP.equals(ing)) {
                    desconto = desconto.add(ing.getValor()
                            .multiply(new BigDecimal(String.valueOf(ing.getQuantidade() == 0 ? 1 : ing.getQuantidade())))
                            .multiply(new BigDecimal("0.33")).setScale(0, BigDecimal.ROUND_HALF_UP));
                }
            });
        });
        return desconto;
    }

//    public BigDecimal verificaPromocaoIngrediente(List<Ingrediente> ingredientes, long ingredienteId) {
//        Ingrediente ingredienteCarne = ingredienteService.get(ingredienteId);
//
//        List<Ingrediente> ingredienteList = ingredientes.stream().filter(ingrediente -> ingrediente.getId() == ingredienteCarne.getId()).collect(Collectors.toList());
//
//        Ingrediente ingrediente = ingredienteList.get(0);
//
//        BigDecimal desconto = new BigDecimal("0");
//
//        if (ingrediente.getQuantidade() > 2 && ingrediente.getQuantidade() % 3 == 0) {
//            desconto = ingrediente.getValor()
//                    .multiply(new BigDecimal(String.valueOf(ingrediente.getQuantidade() == 0 ? 1 : ingrediente.getQuantidade())))
//                    .multiply(new BigDecimal("0.33")).setScale(0, BigDecimal.ROUND_HALF_UP);
//        }
//
//        return desconto;
//    }
}
