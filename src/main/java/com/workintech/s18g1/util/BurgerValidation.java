package com.workintech.s18g1.util;

import com.workintech.s18g1.entity.Burger;
import com.workintech.s18g1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkName(String name) {
        if (name==null||name.isEmpty()){
            throw new ApiException("name can not is empty! ", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkPrice(Double price) {
        if (price==0||price<0){
            throw new ApiException("price cant not is less than 0 or 0",HttpStatus.NOT_FOUND);
        }
    }

    public static void checkId(Integer id) {
        if(id==null||id<0){
            throw new ApiException("id cant not is less than 0 or null",HttpStatus.BAD_REQUEST);
        }
    }
}
