package org.spring.springboot.service;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-05-23 23:42
 **/
@Service
public class RedisService {

        @Autowired
        private RedisTemplate<String, Object> redisTemplate;

        private Set<User> users = new HashSet<User>();

        private Set<City> cities = new HashSet<City>();

        @CachePut(value = "user", key = "'User:'+#user.id")
        public User addUser(User user) {
            users.add(user);
            return user;
        }

        @Cacheable(value = "user", key = "'User:'+#id")
        public User addUser(String id, String name, int age) {
            User user = new User(id, name, age);
            users.add(user);
            return user;
        }

        @Cacheable(value = "user", key = "'User:'+#id")
        public User getStudent(String id) {
            System.out.println("not in redis cache");
            for (User user : users) {
                if (user.getId().equals(id)) {
                    return user;
                }
            }
            return null;
        }

        @CachePut(value = "city", key = "'City:'+#city.id")
        public City addCity(City city) {
            cities.add(city);
            return city;
        }
}
