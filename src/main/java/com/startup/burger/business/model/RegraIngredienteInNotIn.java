package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "regra_ingrediente_in_not_in")
public class RegraIngredienteInNotIn extends BeanIdentificavel {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingrediente_in_id")
    private Ingrediente ingredienteIn;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingrediente_not_in_id")
    private Ingrediente ingredienteNotIn;

    @Transient
    private boolean isPresent;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 1)
    @Column(name = "porcentagem_desconto")
    private BigDecimal porcentagemDesconto;

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Ingrediente getIngredienteIn() {
        return ingredienteIn;
    }

    public void setIngredienteIn(Ingrediente ingredienteIn) {
        this.ingredienteIn = ingredienteIn;
    }

    public Ingrediente getIngredienteNotIn() {
        return ingredienteNotIn;
    }

    public void setIngredienteNotIn(Ingrediente ingredienteNotIn) {
        this.ingredienteNotIn = ingredienteNotIn;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public BigDecimal getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(BigDecimal porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegraIngredienteInNotIn that = (RegraIngredienteInNotIn) o;
        return isPresent == that.isPresent &&
                Objects.equals(promocao, that.promocao) &&
                Objects.equals(ingredienteIn, that.ingredienteIn) &&
                Objects.equals(ingredienteNotIn, that.ingredienteNotIn) &&
                Objects.equals(porcentagemDesconto, that.porcentagemDesconto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), promocao, ingredienteIn, ingredienteNotIn, isPresent, porcentagemDesconto);
    }
}
