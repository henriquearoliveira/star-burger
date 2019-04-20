package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
@Table(name = "pedido_lanche_ingrediente")
public class PedidoLancheIngrediente extends BeanIdentificavel {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_lanche_id")
    private PedidoLanche pedidoLanche;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valor;

    @Column
    private int quantidade;

    public PedidoLanche getPedidoLanche() {
        return pedidoLanche;
    }

    public void setPedidoLanche(PedidoLanche pedidoLanche) {
        this.pedidoLanche = pedidoLanche;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
