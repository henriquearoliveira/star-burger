package com.startup.burger.business.model;

import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido extends BeanIdentificavel {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Size(max = 200, min = 6)
    @NotBlank
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<PedidoLanche> pedidoLanches;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
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
}
