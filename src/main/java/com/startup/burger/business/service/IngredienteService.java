package com.startup.burger.business.service;

import com.startup.burger.business.model.Ingrediente;
import com.startup.burger.business.model.RegraIngredienteMuchMore;
import com.startup.burger.business.repository.IngredienteRepository;
import com.startup.burger.comum.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService extends ServiceAbstract<Ingrediente, IngredienteRepository> {

    private RegraIngredienteMuchMoreService regraIngredienteMuchMoreService;

    @Autowired
    public IngredienteService(RegraIngredienteMuchMoreService regraIngredienteMuchMoreService) {
        this.regraIngredienteMuchMoreService = regraIngredienteMuchMoreService;
    }

    public List<Ingrediente> getIngredientesPromocaoMuch() {
        List<RegraIngredienteMuchMore> regras = regraIngredienteMuchMoreService.findAll();
        return regras.stream().map(RegraIngredienteMuchMore::getIngrediente).collect(Collectors.toList());

    }
}
