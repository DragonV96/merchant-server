package com.glw.platform.common.config;

import com.glw.platform.MerchantApplication;
import com.glw.platform.common.constant.Constants;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : glw
 * @date : 2019/12/2
 * @time : 17:01
 * @Description : swagger api文档
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private String basePackage = MerchantApplication.class.getPackage().getName();

    @Bean
    public Docket restApi() {
        List<Parameter> parameters = new ArrayList<>();
        ParameterBuilder token = new ParameterBuilder();
        token.name(Constants.TOKEN_STRING)
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .order(0);
        parameters.add(token.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("restful接口").select()
                .apis(Predicates.and(RequestHandlerSelectors.basePackage(basePackage)))
                .build()
                .globalOperationParameters(parameters)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商户服务 OPEN RESTful API文档")
                .description("RESTful接口参考和查看API详细信息")
                .termsOfServiceUrl("https://www.github.com/DragonV96")
                .contact(new Contact("glw", "", ""))
                .version("1.0")
                .build();
    }

}
