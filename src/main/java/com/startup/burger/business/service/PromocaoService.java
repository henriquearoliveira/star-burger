package com.startup.burger.business.service;

import com.startup.burger.business.model.Promocao;
import com.startup.burger.business.model.dto.PromocaoDTO;
import com.startup.burger.business.model.enums.TipoRegra;
import com.startup.burger.business.repository.PromocaoRepository;
import com.startup.burger.comum.ServiceAbstract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoService extends ServiceAbstract<Promocao, PromocaoRepository> {

    public Promocao create(PromocaoDTO objeto) {

        // TODO

        return null;
    }

    public List<Promocao> getPromocaoBy(TipoRegra tipoRegra) {
        return super.getJpa().getByTipoRegra(tipoRegra);
    }
}
