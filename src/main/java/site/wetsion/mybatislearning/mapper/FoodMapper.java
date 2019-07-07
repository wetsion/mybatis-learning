package site.wetsion.mybatislearning.mapper;

import org.apache.ibatis.annotations.*;
import site.wetsion.mybatislearning.modal.Food;

/**
 * @author weixin
 * @version 1.0
 * @CLassName FoodMapper
 * @date 2019/6/26 4:25 PM
 */
//@Mapper
@CacheNamespace
public interface FoodMapper {

    @Select("select * from food where id=#{id}")
    Food getById(@Param("id") Long id);

    @Select("select * from food where id=#{id}")
    Food selectById(@Param("id") Long id);

    @Insert("insert into food(name, color) values(#{name}, #{color})")
    int insert(@Param("name") String name, @Param("color") String color);
}
