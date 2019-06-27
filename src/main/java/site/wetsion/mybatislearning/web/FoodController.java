package site.wetsion.mybatislearning.web;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wetsion.mybatislearning.mapper.FoodMapper;
import site.wetsion.mybatislearning.modal.Food;

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

    @GetMapping("/mybatis/test1")
    public void test() {
        Food food = foodMapper.getById(7L);
        log.info(JSON.toJSONString(food));
        Food food2 = foodMapper.getById(7L);
        log.info(JSON.toJSONString(food2));
    }
}
