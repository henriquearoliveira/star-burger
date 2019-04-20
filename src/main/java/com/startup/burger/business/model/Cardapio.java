package com.startup.burger.business.model;

import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cardapio")
public class Cardapio extends BeanIdentificavel {

    @Size(max = 200, min = 6)
    @NotBlank
    private String descricao;

    @ManyToMany()
    @JoinTable(name = "cardapio_lanche",
            joinColumns = {
                    @JoinColumn(name = "cardapio_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "lanche_id")})
    private List<Lanche> lanches;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cardapio cardapio = (Cardapio) o;
        return Objects.equals(descricao, cardapio.descricao) &&
                Objects.equals(lanches, cardapio.lanches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, lanches);
    }
}
