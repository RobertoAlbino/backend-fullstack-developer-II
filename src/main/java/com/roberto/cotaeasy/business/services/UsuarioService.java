package com.roberto.cotaeasy.business.services;

import com.roberto.cotaeasy.business.converter.UsuarioConverter;
import com.roberto.cotaeasy.business.dto.UsuarioDto;
import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.rest.common.RespostaDefault;
import com.roberto.cotaeasy.utils.GenericDao;
import com.roberto.cotaeasy.rest.common.RespostaDefault.RespostaDefaultBuilder;
import com.roberto.cotaeasy.business.queries.UsuarioQueryServiceImpl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioService extends AbstractCrudService<Usuario> {

    private UsuarioQueryServiceImpl usuarioQueryService;

    @Inject
    private GenericDao<Usuario> dao;

    @Override
    protected GenericDao<Usuario> getDao() {
        return dao;
    }

    public RespostaDefault login(UsuarioDto dto) {
        Boolean loginValido =
            usuarioQueryService.loginValido(new UsuarioConverter(new UsuarioDto(), new Usuario()).convertFromDto(dto));
        RespostaDefaultBuilder response = new RespostaDefaultBuilder(loginValido);
        response.addObjeto(new Object());
        if (loginValido) {
            response.addMensagem("Login válido");
        } else {
            response.addMensagem("Login inválido");
        }
        return response.build();
    }
}