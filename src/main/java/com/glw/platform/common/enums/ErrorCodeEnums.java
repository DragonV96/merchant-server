package com.glw.platform.common.enums;

import lombok.Getter;

/**
 * @author : glw
 * @date : 2019/11/29
 * @time : 15:20
 * @Description : 错误码枚举类
 */
@Getter
public enum ErrorCodeEnums {

    SUCCESS(0, "成功"),
    DUPLICATE_NAME(3001, "商户名称重复"),
    EMPTY_LOGO(3002, "商户 logo 为空"),
    EMPTY_BUSINESS_LICENSE(3003, "商户营业执照为空"),
    ERROR_PHONE(3004, "商户联系方式错误"),
    EMPTY_ADDRESS(3005, "商户地址为空"),
    MERCHANT_NOT_EXIST(3006, "商户不存在");

    private Integer code;       // 错误代码
    private String desc;       // 错误描述

    ErrorCodeEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
