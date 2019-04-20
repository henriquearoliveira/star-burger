package com.startup.burger.comum;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class BeanIdentificavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_cadastro")
    @CreatedDate
    private LocalDateTime dataHoraCadastro;

    @Column(name = "data_hora_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataHoraAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanIdentificavel that = (BeanIdentificavel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataHoraCadastro, that.dataHoraCadastro) &&
                Objects.equals(dataHoraAtualizacao, that.dataHoraAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataHoraCadastro, dataHoraAtualizacao);
    }
}
