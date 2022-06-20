package com.it.academy.maintenancestation.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EntityDaoImpl {
//<T> implements EntityDAO<T>
//    protected static EntityManager entityManager;
//    private final Class<T> aClass;
//
//    public EntityDaoImpl(EntityManager entityManager,
//                         Class<T> aClass) {
//        this.aClass = aClass;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<T> findAll() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
//        Root<T> rootEntry = criteriaQuery.from(aClass);
//        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
//        TypedQuery<T> allQuery = entityManager.createQuery(all);
//        return allQuery.getResultList();
//    }
//
//    @Override
//    public T find(Integer id) {
//        T entity = null;
//        try {
//            entity = entityManager.find(aClass, id);
//
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//        entityManager.close();
//        return entity;
//    }
//
//    @Override
//    public void save(T t) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(t);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//        }
//        entityManager.close();
//    }
//
//    @Override
//    public void update(T t) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(t);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            entityManager.getTransaction().rollback();
//        }
//        entityManager.close();
//    }
//
//
//    @Override
//    public void delete(Integer id) {
//        try {
//            T entity = entityManager.find(aClass, id);
//            entityManager.getTransaction().begin();
//            entityManager.remove(entity);
//            entityManager.getTransaction().commit();
//        } catch (RuntimeException e) {
//            entityManager.getTransaction().rollback();
//        }
//        entityManager.close();
//    }
//


}
