package com.glw.platform.entity.vo.request;

import com.glw.platform.dao.MerchantDao;
import com.glw.platform.entity.Merchant;
import com.glw.platform.common.enums.ErrorCodeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : glw
 * @date : 2019/11/30
 * @time : 17:50
 * @Description : 创建商户请求对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "创建商户请求对象")
public class CreateMerchantRequest {

    @ApiModelProperty(value = "商户名称")
    private String name;

    @ApiModelProperty(value = "商户 logo")
    private String logoUrl;

    @ApiModelProperty(value = "商户营业执照")
    private String businessLicenseUrl;

    @ApiModelProperty(value = "商户联系电话")
    private String phone;

    @ApiModelProperty(value = "商户地址")
    private String address;

    /**
     * 校验请求对象的有效性
     * @param merchantDao
     * @return
     */
    public ErrorCodeEnums validate(MerchantDao merchantDao) {
        if (merchantDao.findByName(this.name) != null) {
            return ErrorCodeEnums.DUPLICATE_NAME;
        }
        if (null == this.logoUrl) {
            return ErrorCodeEnums.EMPTY_LOGO;
        }
        if (null == this.businessLicenseUrl) {
            return ErrorCodeEnums.EMPTY_BUSINESS_LICENSE;
        }
        if (null == this.address) {
            return ErrorCodeEnums.EMPTY_ADDRESS;
        }
        if (null == this.phone) {
            return ErrorCodeEnums.ERROR_PHONE;
        }
        return ErrorCodeEnums.SUCCESS;
    }

    /**
     * 将请求对象转换为商户实体对象
     * @return
     */
    public Merchant toMerchant() {
        Merchant merchant = new Merchant();

        merchant.setName(name);
        merchant.setLogoUrl(logoUrl);
        merchant.setBusinessLicenseUrl(businessLicenseUrl);
        merchant.setPhone(phone);
        merchant.setAddress(address);
        merchant.setIsAudit(false);

        return merchant;
    }
}
