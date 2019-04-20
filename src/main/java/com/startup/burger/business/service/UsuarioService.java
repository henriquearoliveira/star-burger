package com.startup.burger.business.service;

import com.startup.burger.business.model.Usuario;
import com.startup.burger.business.model.enums.AuthorityEnum;
import com.startup.burger.business.repository.UsuarioRepository;
import com.startup.burger.comum.ServiceAbstract;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioService extends ServiceAbstract<Usuario, UsuarioRepository> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuario user = super.getJpa().findByUsername(login);
        Collection<GrantedAuthority> authorities = Arrays.stream(AuthorityEnum.values())
                .map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getSenha(), authorities);
    }
}
