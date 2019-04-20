package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lanche")
public class Lanche extends BeanIdentificavel {

    @Size(max = 200, min = 6)
    @NotBlank
    private String descricao;

    @ManyToMany()
    @JoinTable(name = "lanche_ingrediente",
            joinColumns = {
                    @JoinColumn(name = "lanche_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "ingrediente_id")})
    private List<Ingrediente> ingredientes;

    @JsonIgnore
    @ManyToMany(mappedBy = "lanches")
    private List<Cardapio> cardapios;

    @JsonIgnore
    @ManyToMany(mappedBy = "lanche")
    private List<PedidoLanche> pedidoLanches;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lanche lanche = (Lanche) o;
        return Objects.equals(descricao, lanche.descricao) &&
                Objects.equals(ingredientes, lanche.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, ingredientes);
    }
}
