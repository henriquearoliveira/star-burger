package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.business.model.enums.TipoRegra;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "promocao")
public class Promocao extends BeanIdentificavel {

    @NotNull
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_regra")
    private TipoRegra tipoRegra;

//    @ManyToMany()
//    @JoinTable(name = "promocao_pedido_lanche",
//            joinColumns = {
//                    @JoinColumn(name = "promocao_id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "pedido_lanche_id")})
//    private List<PedidoLanche> pedidoLanches;

    @JsonIgnore
    @ManyToMany(mappedBy = "promocoes")
    private List<PedidoLanche> pedidoLanches;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocao")
    private List<RegraIngredienteInNotIn> regraIngredienteInNotInList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocao")
    private List<RegraIngredienteMuchMore> regraIngredienteMuchMoreList;

    public String getDescricao() {
        return descricao;
    }

    public TipoRegra getTipoRegra() {
        return tipoRegra;
    }

    public void setTipoRegra(TipoRegra tipoRegra) {
        this.tipoRegra = tipoRegra;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PedidoLanche> getPedidoLanches() {
        return pedidoLanches;
    }

    public void setPedidoLanches(List<PedidoLanche> pedidoLanches) {
        this.pedidoLanches = pedidoLanches;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Promocao promocao = (Promocao) o;
        return Objects.equals(descricao, promocao.descricao) &&
                Objects.equals(pedidoLanches, promocao.pedidoLanches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, pedidoLanches);
    }
}
