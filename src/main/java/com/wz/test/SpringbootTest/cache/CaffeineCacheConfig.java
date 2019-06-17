package com.wz.test.SpringbootTest.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CaffeineCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder()
                //cache的初始容量值
                .initialCapacity(100)
                //maximumSize用来控制cache的最大缓存数量
                .maximumSize(3000)
                // 访问过期时间10分钟
                .expireAfterAccess(600, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        List<String> names = new ArrayList<String>();
        names.add("itemInfo");
        names.add("hostInfo");
        cacheManager.setCacheNames(names);
        return cacheManager;
    }
}
