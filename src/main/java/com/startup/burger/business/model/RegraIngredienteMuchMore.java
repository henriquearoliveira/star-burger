package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "regra_ingrediente_much")
public class RegraIngredienteMuchMore extends BeanIdentificavel {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @Column
    private int quantidade;

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegraIngredienteMuchMore that = (RegraIngredienteMuchMore) o;
        return quantidade == that.quantidade &&
                Objects.equals(promocao, that.promocao) &&
                Objects.equals(ingrediente, that.ingrediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promocao, ingrediente, quantidade);
    }
}
