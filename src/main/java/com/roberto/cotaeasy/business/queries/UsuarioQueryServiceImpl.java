package com.roberto.cotaeasy.business.queries;

import com.roberto.cotaeasy.business.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioQueryServiceImpl {

    private EntityManager entityManager;

    public UsuarioQueryServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean loginValido(Usuario usuario) {
        TypedQuery<Usuario> query = entityManager
                .createQuery("SELECT nome FROM usuarios where email = :email and senha = :senha", Usuario.class);
        query.setParameter("email", usuario.getEmail());
        query.setParameter("senha", usuario.getSenha());
        return query.getSingleResult() != null ? true : false;
    }
}
