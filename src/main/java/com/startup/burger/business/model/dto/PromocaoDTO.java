package com.startup.burger.business.model.dto;

import com.startup.burger.business.model.Ingrediente;
import com.startup.burger.business.model.enums.TipoRegra;
import org.springframework.lang.NonNull;

import java.io.Serializable;

public class PromocaoDTO implements Serializable {

    @NonNull
    private String descricao;
    @NonNull
    private TipoRegra tipoRegra;
    private Ingrediente ingredienteMuchMore;
    private Ingrediente ingredienteNotIN;
    private Ingrediente ingredienteIn;
    private int porcentagemDesconto;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoRegra getTipoRegra() {
        return tipoRegra;
    }

    public void setTipoRegra(TipoRegra tipoRegra) {
        this.tipoRegra = tipoRegra;
    }

    public Ingrediente getIngredienteMuchMore() {
        return ingredienteMuchMore;
    }

    public void setIngredienteMuchMore(Ingrediente ingredienteMuchMore) {
        this.ingredienteMuchMore = ingredienteMuchMore;
    }

    public Ingrediente getIngredienteNotIN() {
        return ingredienteNotIN;
    }

    public void setIngredienteNotIN(Ingrediente ingredienteNotIN) {
        this.ingredienteNotIN = ingredienteNotIN;
    }

    public Ingrediente getIngredienteIn() {
        return ingredienteIn;
    }

    public void setIngredienteIn(Ingrediente ingredienteIn) {
        this.ingredienteIn = ingredienteIn;
    }

    public int getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(int porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}
