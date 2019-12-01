package com.glw.platform.service;

import com.glw.platform.entity.vo.CoupouTemplate;
import com.glw.platform.entity.vo.request.CreateMerchantRequest;
import com.glw.platform.entity.vo.response.Response;

/**
 * @author : glw
 * @date : 2019/12/1
 * @time : 19:07
 * @Description : 商户服务接口
 */
public interface IMerchantService {

    /**
     * 创建商户服务
     * @param request
     * @return
     */
    Response createMerchant(CreateMerchantRequest request);

    /**
     * 根据 id 构造商户信息
     * @param id
     * @return
     */
    Response buildMerchantInfoById(Integer id);

    /**
     * 投放优惠券
     * @param template
     * @return
     */
    Response dropCoupouTemplate(CoupouTemplate template);
}
