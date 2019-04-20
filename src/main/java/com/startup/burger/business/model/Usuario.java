package com.startup.burger.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startup.burger.comum.BeanIdentificavel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario extends BeanIdentificavel {

    @Size(max = 200, min = 6)
    @NotBlank
    private String nome;

    @Size(max = 100, min = 6)
    @NotBlank
    private String email;

    @Size(max = 100, min = 6)
    @NotBlank
    @Column(unique = true)
    private String username;

    @Size(max = 200, min = 6)
    @NotBlank
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
