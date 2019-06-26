package site.wetsion.mybatislearning.modal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author weixin
 * @version 1.0
 * @CLassName Food
 * @date 2019/6/26 4:25 PM
 */
@Data
public class Food implements Serializable {

    private Long id;

    private String name;

    private String color;
}
