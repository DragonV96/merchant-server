package com.glw.platform.entity.vo;

import com.glw.platform.dao.MerchantDao;
import com.glw.platform.enums.ErrorCodeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : glw
 * @date : 2019/11/30
 * @time : 15:46
 * @Description : 优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "优惠券模板对象")
public class CoupouTemplate {

    @ApiModelProperty(value = "所属商户 id")
    private Integer id;

    @ApiModelProperty(value = "优惠券标题")
    private String title;

    @ApiModelProperty(value = "优惠券摘要")
    private String summary;

    @ApiModelProperty(value = "优惠券的详细信息")
    private String desc;

    @ApiModelProperty(value = "优惠券最大个数限制")
    private String limit;

    // token 存到redis Set中，每次领取从redis中获取
    @ApiModelProperty(value = "优惠券的是否有 token")
    private String hasToken;

    @ApiModelProperty(value = "优惠券的背景色")
    private String backgroud;

    @ApiModelProperty(value = "优惠券的开始时间")
    private String start;

    @ApiModelProperty(value = "优惠券的结束时间")
    private String end;

    /**
     * 校验优惠券对象的有效性
     * @param merchantDao
     * @return
     */
    public ErrorCodeEnums validate(MerchantDao merchantDao) {
        if (null == merchantDao.findById(id)) {
            return ErrorCodeEnums.MERCHANT_NOT_EXIST;
        }
        return ErrorCodeEnums.SUCCESS;
    }
}
