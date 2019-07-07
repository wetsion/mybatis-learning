package site.wetsion.mybatislearning.web;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wetsion.mybatislearning.mapper.FoodMapper;
import site.wetsion.mybatislearning.modal.Food;
import site.wetsion.mybatislearning.service.FoodService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weixin
 * @version 1.0
 * @CLassName FoodController
 * @date 2019/6/26 4:28 PM
 */
@RestController
@Slf4j
public class FoodController {

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    BeanFactory factory;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @GetMapping("/mybatis/test1")
    public void test() {
        Food food = foodMapper.getById(1L);
        log.info(JSON.toJSONString(food));
        Food food2 = foodMapper.getById(1L);
        log.info(JSON.toJSONString(food2));
    }

    @GetMapping("/mybatis/test2")
    public void test2() {
        SqlSession session = sqlSessionFactory.openSession();
        Food food = (Food) session.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 1L);
        log.info(JSON.toJSONString(food));
        Food food2 = (Food) session.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 1L);
        log.info(JSON.toJSONString(food2));
    }

    @GetMapping("/mybatis/test3")
    public void test3() {
        SqlSession session = sqlSessionFactory.openSession();
        Food food = (Food) session.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 1L);
        log.info(JSON.toJSONString(food));
        Food food2 = (Food) session.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.selectById", 1L);
        log.info(JSON.toJSONString(food2));
    }

    @GetMapping("/mybatis/test4")
    public void test4() {
        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        Food food = (Food) session.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 1L);
        session.commit();
        log.info(JSON.toJSONString(food));
        Food food2 = (Food) session2.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 1L);
        log.info(JSON.toJSONString(food2));
    }

    @GetMapping("/mybatis/test5")
    public void test5() {
        SqlSession session = sqlSessionFactory.openSession();
        Map<String, String> map = new HashMap();
        map.put("name", "bb");
        map.put("color", "white");
        session.insert("site.wetsion.mybatislearning.mapper.FoodMapper.insert", map);
        session.commit();
        session.close();
        SqlSession session2 = sqlSessionFactory.openSession();
        Food food2 = (Food) session2.selectOne(
                "site.wetsion.mybatislearning.mapper.FoodMapper.getById", 5L);
        session2.commit();
        session2.close();
        log.info(JSON.toJSONString(food2));
    }

    @Autowired
    FoodService foodService;

    @GetMapping("/mybatis/test6")
    public void test6() {
        foodService.get();
    }
}
