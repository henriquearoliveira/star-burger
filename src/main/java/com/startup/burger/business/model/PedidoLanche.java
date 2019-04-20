package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedido_lanche")
public class PedidoLanche extends BeanIdentificavel {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "lanche_id")
    private Lanche lanche;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    private BigDecimal total;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    private BigDecimal desconto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoLanche")
    private List<PedidoLancheIngrediente> pedidoLancheIngredientes;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "pedidoLanches")
//    private List<Promocao> promocoes;

    @ManyToMany()
    @JoinTable(name = "promocao_pedido_lanche",
            joinColumns = {
                    @JoinColumn(name = "pedido_lanche_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "promocao_id")})
    private List<Promocao> promocoes;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public List<PedidoLancheIngrediente> getPedidoLancheIngredientes() {
        return pedidoLancheIngredientes;
    }

    public void setPedidoLancheIngredientes(List<PedidoLancheIngrediente> pedidoLancheIngredientes) {
        this.pedidoLancheIngredientes = pedidoLancheIngredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PedidoLanche that = (PedidoLanche) o;
        return Objects.equals(pedido, that.pedido) &&
                Objects.equals(lanche, that.lanche) &&
                Objects.equals(total, that.total) &&
                Objects.equals(desconto, that.desconto) &&
                Objects.equals(pedidoLancheIngredientes, that.pedidoLancheIngredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pedido, lanche, total, desconto, pedidoLancheIngredientes);
    }
}
