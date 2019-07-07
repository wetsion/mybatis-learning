package site.wetsion.mybatislearning.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wetsion.mybatislearning.mapper.FoodMapper;
import site.wetsion.mybatislearning.modal.Food;

/**
 * Created by wetsion on 2019/7/6.
 */
@Service
@Slf4j
@Transactional
public class FoodService {

    @Autowired
    FoodMapper foodMapper;

    public void get() {
        Food food = foodMapper.getById(1L);
        log.info(JSON.toJSONString(food));
        Food food2 = foodMapper.getById(1L);
        log.info(JSON.toJSONString(food2));
    }
}
