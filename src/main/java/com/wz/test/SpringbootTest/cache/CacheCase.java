package com.wz.test.SpringbootTest.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheCase {

    private static int getNum ;
    private static int putNum ;
    @Cacheable( value = "itemInfo" , key = "#id")
    public String getItemById(Integer id){
        getNum++;
        System.out.println("getByMethod key:"+id);
       return "get"+getNum;
    }

    @CachePut(value = "itemInfo" , key="#itemId")
    public String setItemInfo(Integer itemId){
        putNum++;
        System.out.println("put key:"+itemId+" value:"+"put"+putNum);
        return "put"+putNum;
    }

    @CacheEvict(value = "itemInfo" , key="#itemId")
    public void deleteItemaInfo(Integer itemId){
        System.out.println("evict item id:"+itemId);
    }

}
