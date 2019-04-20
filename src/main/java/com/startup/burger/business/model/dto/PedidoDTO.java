package com.startup.burger.business.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.business.model.Lanche;
import com.startup.burger.business.model.Usuario;

import java.io.Serializable;
import java.util.List;

public class PedidoDTO implements Serializable {

    private String descricao;
    private List<Lanche> lanches;

    @JsonIgnore
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
