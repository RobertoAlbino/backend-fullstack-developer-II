package com.roberto.cotaeasy.business.queries;

import com.roberto.cotaeasy.business.dto.LoginDto;
import com.roberto.cotaeasy.business.models.Usuario;

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

    public boolean loginValido(LoginDto dto) {
        TypedQuery<String> query = entityManager
                .createQuery("SELECT nome FROM usuarios where email = :email and senha = :senha", String.class);
        query.setParameter("email", dto.getEmail());
        query.setParameter("senha", dto.getSenha());
        return query.getFirstResult() > 0 ? true : false;
    }
}
