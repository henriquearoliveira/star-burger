package com.startup.burger.comum;

import com.startup.burger.exceptions.BurgerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ServiceAbstract<T extends BeanIdentificavel, E extends JpaRepository<T, Long>> implements IServices<T> {

    @Autowired
    private E jpa;

    @Override
    public T atualiza(T objeto) {

        verificaExistencia(objeto);
        LocalDateTime dataCadastro = get(objeto.getId()).getDataHoraCadastro();
        objeto.setDataHoraAtualizacao(LocalDateTime.now());
        objeto.setDataHoraCadastro(dataCadastro);

        try {
            return jpa.save(objeto);
        } catch (DataIntegrityViolationException e) {
            throw new BurgerException("O objeto não é possível ser atualizado.", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public T get(Long id) {

        Optional<T> objeto = jpa.findById(id);

        return objeto.orElseThrow(() -> new BurgerException("O objeto requisitado não existe.", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<T> findAll() {
        return jpa.findAll();
    }

    @Override
    public T insere(T objeto) {

        objeto.setId(null);
        objeto.setDataHoraCadastro(LocalDateTime.now());

        try {

            return jpa.save(objeto);

        } catch (DataIntegrityViolationException e) {
            throw new BurgerException("Conflito com integridade.", HttpStatus.CONFLICT);
        }

    }

    @Override
    public void remove(Long id) {
        T objeto = get(id);

        try {
            jpa.delete(objeto);
        } catch (DataIntegrityViolationException e) {
            throw new BurgerException("Objeto com dependencias.", HttpStatus.UNAUTHORIZED);
        }
    }

    public E getJpa() {
        return jpa;
    }
}
