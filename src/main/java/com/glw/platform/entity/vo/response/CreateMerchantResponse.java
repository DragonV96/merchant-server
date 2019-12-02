package com.glw.platform.entity.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "创建商户响应对象")
public class CreateMerchantResponse {

    @ApiModelProperty(value = "商户id，创建失败则为 -1")
    private Integer id;
}
