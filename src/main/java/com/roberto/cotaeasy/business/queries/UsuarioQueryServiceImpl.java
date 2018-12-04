package com.roberto.cotaeasy.business.queries;

import com.roberto.cotaeasy.business.dto.LoginDto;
import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.utils.MD5Utils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioQueryServiceImpl {

    @Inject
    private EntityManager entityManager;

    public Usuario loginValido(LoginDto dto) {
        TypedQuery<Usuario> query = entityManager
                .createQuery("SELECT usuario FROM usuarios usuario where usuario.email = :email and usuario.senha = :senha", Usuario.class).setMaxResults(1);
        query.setParameter("email", dto.getEmail());
        query.setParameter("senha", MD5Utils.encript(dto.getSenha()));
        return query.getSingleResult();
    }
}
