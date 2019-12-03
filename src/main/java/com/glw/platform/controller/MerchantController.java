package com.glw.platform.controller;

import com.alibaba.fastjson.JSON;
import com.glw.platform.entity.vo.CoupouTemplate;
import com.glw.platform.entity.vo.request.CreateMerchantRequest;
import com.glw.platform.entity.vo.response.Response;
import com.glw.platform.service.IMerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : glw
 * @date : 2019/12/2
 * @time : 14:48
 * @Description : 商户服务控制层
 */
@Slf4j
@RestController
@RequestMapping("/merchant")
@Api(tags = "商户服务接口", description = "商户服务接口")
public class MerchantController {

    @Autowired
    private IMerchantService merchantService;

    @ApiOperation(value = "创建商户服务", notes = "创建商户服务")
    @PostMapping("/create")
    @ResponseBody
    public Response createMerchant(@RequestBody CreateMerchantRequest request) {
        log.info("MerchantController createMerchant：{}", JSON.toJSONString(request));
        return merchantService.createMerchant(request);
    }

    @ApiOperation(value = "构造商户信息", notes = "根据 id 构造商户信息")
    @PostMapping("/{id}")
    @ResponseBody
    public Response buildMerchantInfoById(@PathVariable Integer id) {
        log.info("MerchantController buildMerchantInfoById：{}", id);
        return merchantService.buildMerchantInfoById(id);
    }

    @ApiOperation(value = "投放优惠券", notes = "投放优惠券")
    @PostMapping("/dropCoupou")
    @ResponseBody
    public Response dropCoupouTemplate(@RequestBody CoupouTemplate template) {
        log.info("MerchantController dropCoupouTemplate：{}", template);
        return merchantService.dropCoupouTemplate(template);
    }

}
