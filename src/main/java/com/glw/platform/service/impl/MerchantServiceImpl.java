package com.glw.platform.service.impl;

import com.glw.platform.dao.MerchantDao;
import com.glw.platform.entity.vo.CoupouTemplate;
import com.glw.platform.entity.vo.request.CreateMerchantRequest;
import com.glw.platform.entity.vo.response.CreateMerchantResponse;
import com.glw.platform.entity.vo.response.Response;
import com.glw.platform.enums.ErrorCodeEnums;
import com.glw.platform.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : glw
 * @date : 2019/12/1
 * @time : 23:38
 * @Description : 商户服务接口实现类
 */
@Slf4j
@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    @Transactional
    public Response createMerchant(CreateMerchantRequest request) {
        Response response = new Response();
        CreateMerchantResponse createMerchantResponse = new CreateMerchantResponse();

        ErrorCodeEnums errorCode = request.validate(merchantDao);
        if (errorCode != ErrorCodeEnums.SUCCESS) {
            createMerchantResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setMsg(errorCode.getDesc());
        } else {
            createMerchantResponse.setId(merchantDao.save(request.toMerchant()).getId());
        }

        response.setData(createMerchantResponse);
        return response;
    }

    @Override
    public Response buildMerchantInfoById(Integer id) {
        return null;
    }

    @Override
    public Response dropCoupouTemplate(CoupouTemplate template) {
        return null;
    }
}
