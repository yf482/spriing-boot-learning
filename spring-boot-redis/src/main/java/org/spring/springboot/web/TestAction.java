package org.spring.springboot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.CityService;
import org.spring.springboot.service.RedisService;
import org.spring.springboot.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-05-23 23:18
 **/
@RestController
@RequestMapping("/test")
public class TestAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityService cityService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private City getShanghai(){
        return new City(1L, 10L, "上海", "人称魔都的地方");
    }

    private City getBeijing(){
        return new City(2L, 20L, "北京", "中国帝都");
    }

    @RequestMapping("/add")
    public String test(){
        City city = getBeijing();
        // 向 redis 中存入数据
        cityService.saveCity(city);

        // 从 redis 中取数据, 第一次查询
        City cityInfo = cityService.getCityByName("北京");
        LOGGER.info("第一次查询：" + cityInfo.toString());

        // 从 redis 中取数据, 第二次查询
        cityInfo = cityService.getCityByName("北京");
        LOGGER.info("第二次查询：" + cityInfo.toString());

        // 更新 city 的描述信息后查询
        cityService.updateCityDescription("北京", "想不想去北京玩玩呢？");
        cityInfo = cityService.getCityByName("北京");
        LOGGER.info("更新描述后查询：" + cityInfo.toString());
        return "";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/add2")
    public String test2(){
        User user=new User("student1","name",19);
        redisService.addUser(user);
        LOGGER.info("RedisTest执行完成，return {}",redisService.getStudent(user.getId()).getId());
        return "success";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/getKey")
    public String getKey(String key){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            String val = (String) valueOperations.get(key);
            System.out.println("val = " + val);
        }
        return "success";
    }


    /**
     *
     * @return
     */
    @RequestMapping("/setKey")
    public String setKey(String key,String value){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            String val = (String) valueOperations.get(key);
            System.out.println("val = " + val);
        }else{
            RedisSerializer<String> redisSerializer = stringRedisTemplate.getStringSerializer();
            stringRedisTemplate.setKeySerializer(redisSerializer);
        }
        return "success";
    }
}
