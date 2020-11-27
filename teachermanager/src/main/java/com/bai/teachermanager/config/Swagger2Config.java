package com.bai.teachermanager.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 文档配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config{

    /**
     * web api  的配置
     * @return
     */
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //只显示api路径下的页面  路径过滤  拦截只有api 开头的路径才能访问到 swagger2
                .paths(Predicates.and(PathSelectors.regex("/teachermanager/api/.*")))
                .build();
    }


    /**
     * adminapi的配置
     * @return
     */
    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示api路径下的页面  路径过滤  拦截只有api 开头的路径才能访问到 swagger2
                .paths(Predicates.and(PathSelectors.regex("/teachermanager/.*")))
                .build();
    }

    /**
     * web  接口信息
     * @return
     */
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("escoding","https://github.com/byescoding?tab=repositories","1796898704@qq.com"))
                .build();
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("escoding","https://github.com/byescoding?tab=repositories","1796898704@qq.com"))
                .build();
    }
}
