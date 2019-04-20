package com.startup.burger.comum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class ResourceAbstract<T extends BeanIdentificavel, S extends IServices<T>> extends ResourceBasic implements IResources<T> {

    @Autowired
    protected S services;

    @Override
    public ResponseEntity<Void> atualiza(@PathVariable("id") Long id, @Valid @RequestBody T objeto) {
        objeto.setId(id);
        services.atualiza(objeto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<T> get(@PathVariable("id") Long id) {
        T objeto = services.get(id);
        return ResponseEntity.ok(objeto);
    }

    @Override
    public ResponseEntity<List<T>> findAll() {
        List<T> objetos = services.findAll();
        return ResponseEntity.ok(objetos);
    }

    @Override
    public ResponseEntity<T> insere(@Valid @RequestBody T objeto) {
        services.insere(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(objeto);
    }

    @Override
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        services.remove(id);
        return ResponseEntity.noContent().build();
    }
}
