package com.roberto.cotaeasy.business.services;

import com.roberto.cotaeasy.business.models.Entidade;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class PersistenceService<T extends Entidade> {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cotaeasy");
    private static EntityManager em = factory.createEntityManager();
    private @Resource UserTransaction utx;

    private void initializeContext() {
        try {
            InitialContext ctx = new InitialContext();
            utx = (UserTransaction)ctx.lookup("java:jboss/UserTransaction");
            utx.begin();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public T insert(T entity) {
        try {
            initializeContext();
            em.persist(entity);
            utx.commit();
            return entity;
        } catch(Exception ex) {
            return null;
        }
    }
}