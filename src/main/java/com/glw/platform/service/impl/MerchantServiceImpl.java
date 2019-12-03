package com.glw.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.glw.platform.common.constant.Constants;
import com.glw.platform.dao.MerchantDao;
import com.glw.platform.entity.Merchant;
import com.glw.platform.entity.vo.CoupouTemplate;
import com.glw.platform.entity.vo.request.CreateMerchantRequest;
import com.glw.platform.entity.vo.response.CreateMerchantResponse;
import com.glw.platform.entity.vo.response.Response;
import com.glw.platform.common.enums.ErrorCodeEnums;
import com.glw.platform.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

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
        Response response = new Response();

        Optional<Merchant> optional = merchantDao.findById(id);
        Merchant merchant = optional.get();
        if (null == merchant) {
            response.setErrorCode(ErrorCodeEnums.MERCHANT_NOT_EXIST.getCode());
            response.setMsg(ErrorCodeEnums.MERCHANT_NOT_EXIST.getDesc());
        }
        response.setData(merchant);

        return response;
    }

    @Override
    public Response dropCoupouTemplate(CoupouTemplate template) {
        Response response = new Response();
        ErrorCodeEnums errorCode = template.validate(merchantDao);

        if (errorCode != ErrorCodeEnums.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setMsg(errorCode.getDesc());
        } else {
            response.setData(template);
            String coupouTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(Constants.TEMPLATE_TOPIC, Constants.TEMPLATE_TOPIC, coupouTemplate);
            log.info("MerchantServiceImpl dropCoupouTemplate：{}", coupouTemplate);
        }

        return response;
    }
}
