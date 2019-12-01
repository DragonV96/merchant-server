package com.glw.platform.entity.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : glw
 * @date : 2019/11/30
 * @time : 17:35
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * 错误码，成功则返回0
     */
    private Integer errorCode = 0;

    /**
     * 描述信息，正确返回“成功”
     */
    private String msg = "成功";

    /**
     * 响应对象
     */
    private Object data;

    public Response(Object data) {
        this.data = data;
    }
}
