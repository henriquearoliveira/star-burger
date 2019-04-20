package com.startup.burger.business.service;

import com.startup.burger.business.model.Ingrediente;

import java.math.BigDecimal;
import java.util.List;

public interface IPromocao {

    BigDecimal calcDescontoPromocao(List<Ingrediente> ingredientes);

}
