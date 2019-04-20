package com.startup.burger.comum;

import com.startup.burger.business.model.Usuario;
import com.startup.burger.business.service.UsuarioService;
import com.startup.burger.exceptions.BurgerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ResourceBasic {

    @Autowired
    private UsuarioService usuarioServices;

    /**
     * @return Authentication
     */
    public Usuario getAutenticacao(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        if(username.equals("anonymousUser"))
            throw new BurgerException("Não Autorizado", HttpStatus.UNAUTHORIZED);

        return usuarioServices.getJpa().findByUsername(username);
    }
}
