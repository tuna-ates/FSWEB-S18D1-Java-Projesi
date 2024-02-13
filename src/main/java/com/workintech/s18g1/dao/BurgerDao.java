package com.workintech.s18g1.dao;

import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;

import java.util.List;

public interface BurgerDao {
    public Burger save(Burger burger);

    public Burger findById(Integer id);

    public List<Burger> findAll();

    public List<Burger> findByPrice(Double price);
    public List<Burger> findByBreadType(BreadType breadType);

    public List<Burger> findByContent(String content);

    public Burger update(Burger burger);
    public Burger remove(Integer id);

}
