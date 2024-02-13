package com.workintech.s18g1.dao;

import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;
import com.workintech.s18g1.exceptions.ApiException;
import com.workintech.s18g1.util.BurgerValidation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BurgerDaoImpl implements BurgerDao{
    private final EntityManager entityManager;
    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> selectBFromBurgerB = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return selectBFromBurgerB.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger>selectFromPrice  = entityManager.createQuery("SELECT b FROM Burger b where b.price > :price ORDER BY b.price desc",Burger.class);
        selectFromPrice.setParameter("price",price);
        return selectFromPrice.getResultList();
    }

    @Override
    public Burger findById(Integer id) {
       Burger burger= entityManager.find(Burger.class,id);
        if (burger==null){
            throw new ApiException("Burger given id is not exist: "+id, HttpStatus.NOT_FOUND);
        }
        return burger;
    }




    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger where b.breadType=:breadType ORDER BY b.name desc", Burger.class);
        query.setParameter("breadType",breadType);
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger where b.contents like CONTAC('%',:content,'%') ORDER BY b.name", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }
    @Transactional
    @Override
    public Burger update(Burger burger) {
        entityManager.merge(burger);
        return null;
    }
    @Transactional
    @Override
    public Burger remove(Integer id) {
          Burger burger=findById(id);
          entityManager.remove(burger);
          return  burger;
    }
}
