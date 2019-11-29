package com.glw.platform.enums;

import lombok.Getter;

/**
 * @author : glw
 * @date : 2019/11/29
 * @time : 15:17
 * @Description : 优惠券背景色枚举类
 */
@Getter
public enum TemplateColorEnums {

    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色");

    private Integer code;       // 颜色代码
    private String color;       // 颜色描述

    TemplateColorEnums(Integer code, String color) {
        this.code = code;
        this.color = color;
    }
}
