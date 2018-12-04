package com.roberto.cotaeasy.business.services;

import com.roberto.cotaeasy.business.converter.UsuarioConverter;
import com.roberto.cotaeasy.business.dto.LoginDto;
import com.roberto.cotaeasy.business.dto.UsuarioDto;
import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.rest.common.RespostaDefault;
import com.roberto.cotaeasy.rest.common.RespostaDefault.RespostaDefaultBuilder;
import com.roberto.cotaeasy.business.queries.UsuarioQueryServiceImpl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioService {

    @Inject
    private UsuarioQueryServiceImpl usuarioQueryService;

    @Inject
    private PersistenceService<Usuario> persistenceService;

    public RespostaDefault login(LoginDto dto) {
        Usuario usuario = usuarioQueryService.loginValido(dto);
        Boolean sucessoLogin = usuario != null;
        return new RespostaDefaultBuilder()
                .addSucesso(sucessoLogin)
                .addObjeto(usuario)
                .addMensagem(sucessoLogin ? "Login válido" : "Login inválido")
                .build();
    }

    public RespostaDefault criar(UsuarioDto dto) {
        Usuario novoUsuario = persistenceService.insert(new UsuarioConverter().toEntity(dto));
        Boolean usuarioValido = novoUsuario != null;
        return new RespostaDefaultBuilder()
                .addSucesso(usuarioValido)
                .addObjeto(novoUsuario)
                .addMensagem(usuarioValido ? "Usuário criado com sucesso" : "Não foi possível criar o usuário")
                .build();
    }
}