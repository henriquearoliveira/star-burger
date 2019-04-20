package com.startup.burger.comum;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface IResources<T extends BeanIdentificavel> {

    @PutMapping(value = "/{id}")
    ResponseEntity<Void> atualiza(Long id, T objeto);

    @GetMapping
    ResponseEntity<List<T>> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<T> get(Long id);

    @PostMapping
    ResponseEntity<T> insere(T objeto);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> remove(Long id);

    default String getIdentidade() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
