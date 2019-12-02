package com.glw.platform.entity.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : glw
 * @date : 2019/11/30
 * @time : 17:35
 * @Description : 通用响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通用响应对象")
public class Response {

    @ApiModelProperty(value = "错误码，成功则返回0")
    private Integer errorCode = 0;

    @ApiModelProperty(value = "描述信息，正确返回“成功”")
    private String msg = "成功";

    @ApiModelProperty(value = "响应对象")
    private Object data;

    public Response(Object data) {
        this.data = data;
    }
}
