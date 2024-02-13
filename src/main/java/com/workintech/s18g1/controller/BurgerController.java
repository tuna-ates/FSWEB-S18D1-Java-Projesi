package com.workintech.s18g1.controller;

import com.workintech.s18g1.dao.BurgerDao;
import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;
import com.workintech.s18g1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDaoImpl;
    @Autowired
    public BurgerController(BurgerDao burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }
@GetMapping("/")
    public List<Burger> findAll(){
       return burgerDaoImpl.findAll();
    }
@GetMapping("/{id}")
public Burger findById(@PathVariable int id){
        return burgerDaoImpl.findById(id);
}

@PostMapping("/")
    public Burger save(@RequestBody Burger burger){
    BurgerValidation.checkName(burger.getName());
    BurgerValidation.checkPrice(burger.getPrice());
    BurgerValidation.checkId(burger.getId());
    return burgerDaoImpl.save(burger);
}
@PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        BurgerValidation.checkPrice(burger.getPrice());
        BurgerValidation.checkName(burger.getName());
        return burgerDaoImpl.update(burger);
}

@DeleteMapping("/{id}")
    public Burger remove(@PathVariable int id){
        Burger burger=findById(id);
        BurgerValidation.checkId(id);
        burgerDaoImpl.remove(id);
        return burger;
}

@GetMapping("/{findByPrice}")
    public List<Burger> findByPrice(@PathVariable double findByPrice ){
        BurgerValidation.checkPrice(findByPrice);
       return burgerDaoImpl.findByPrice(findByPrice);

}
@GetMapping("/{findByBreadType}")
    public List<Burger> findByBread(@PathVariable BreadType findByBreadType ){

        return burgerDaoImpl.findByBreadType(findByBreadType);
}

@GetMapping("/{findByContent}")
    public List<Burger> findByContent(@PathVariable String findByContent){
        return  burgerDaoImpl.findByContent(findByContent);
}

}
