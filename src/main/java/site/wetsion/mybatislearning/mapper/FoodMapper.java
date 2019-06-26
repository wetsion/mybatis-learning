package site.wetsion.mybatislearning.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.wetsion.mybatislearning.modal.Food;

/**
 * @author weixin
 * @version 1.0
 * @CLassName FoodMapper
 * @date 2019/6/26 4:25 PM
 */
@Mapper
public interface FoodMapper {

    @Select("select * from food where id=#{id}")
    Food getById(@Param("id") Long id);
}
