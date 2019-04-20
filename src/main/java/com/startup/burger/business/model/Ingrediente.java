package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ingrediente")
public class Ingrediente extends BeanIdentificavel {

    @Size(max = 200, min = 6)
    @NotBlank
    private String descricao;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valor;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredientes")
    private List<Lanche> lanches;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<PedidoLancheIngrediente> pedidoLancheIngredientes;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredienteIn")
    private List<RegraIngredienteInNotIn> regraIngredienteInList;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredienteNotIn")
    private List<RegraIngredienteInNotIn> regraIngredienteInNotInList;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<RegraIngredienteMuchMore> regraIngredienteMuchMoreList;

    @Transient
    private int quantidade = 1;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }

    public List<PedidoLancheIngrediente> getPedidoLancheIngredientes() {
        return pedidoLancheIngredientes;
    }

    public void setPedidoLancheIngredientes(List<PedidoLancheIngrediente> pedidoLancheIngredientes) {
        this.pedidoLancheIngredientes = pedidoLancheIngredientes;
    }

    public List<RegraIngredienteInNotIn> getRegraIngredienteInList() {
        return regraIngredienteInList;
    }

    public void setRegraIngredienteInList(List<RegraIngredienteInNotIn> regraIngredienteInList) {
        this.regraIngredienteInList = regraIngredienteInList;
    }

    public List<RegraIngredienteInNotIn> getRegraIngredienteInNotInList() {
        return regraIngredienteInNotInList;
    }

    public void setRegraIngredienteInNotInList(List<RegraIngredienteInNotIn> regraIngredienteInNotInList) {
        this.regraIngredienteInNotInList = regraIngredienteInNotInList;
    }

    public List<RegraIngredienteMuchMore> getRegraIngredienteMuchMoreList() {
        return regraIngredienteMuchMoreList;
    }

    public void setRegraIngredienteMuchMoreList(List<RegraIngredienteMuchMore> regraIngredienteMuchMoreList) {
        this.regraIngredienteMuchMoreList = regraIngredienteMuchMoreList;
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
        if (!super.equals(o)) return false;
        Ingrediente that = (Ingrediente) o;
        return quantidade == that.quantidade &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(lanches, that.lanches) &&
                Objects.equals(pedidoLancheIngredientes, that.pedidoLancheIngredientes) &&
                Objects.equals(regraIngredienteInList, that.regraIngredienteInList) &&
                Objects.equals(regraIngredienteInNotInList, that.regraIngredienteInNotInList) &&
                Objects.equals(regraIngredienteMuchMoreList, that.regraIngredienteMuchMoreList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, valor, lanches, pedidoLancheIngredientes, regraIngredienteInList, regraIngredienteInNotInList, regraIngredienteMuchMoreList, quantidade);
    }
}
