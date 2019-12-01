package com.glw.platform.entity.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : glw
 * @date : 2019/12/1
 * @time : 17:37
 * @Description : 创建商户响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantResponse {

    /**
     * 商户id，创建失败则为 -1
     */
    private Integer id;
}
