package com.swagger.study.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author wanggy5
 * @DATE 2020/05/21 18:27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors 配置要扫描的方式
                // basePackage:指定要扫描的包 any() 全部扫描
                .apis(RequestHandlerSelectors.basePackage("com.swagger.study.swaggerdemo.controller"))
                .build();
    }

    /**
     * 作者信息
     */
    Contact contact = new Contact("wanggy5", "www.baidu.com", "1083401787@qq.com");

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Api文档",
                "文档描述",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList()
        );
    }

}
