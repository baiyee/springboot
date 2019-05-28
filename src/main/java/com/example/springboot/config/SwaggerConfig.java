package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.springboot")) // 配置需要扫描的包路径
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		//访问地址http://localhost:8081/swagger-ui.html#/swagger-controller
		return new ApiInfoBuilder().title("每特教育|蚂蚁课堂").description("蚂蚁课堂|每特教育专注于分布式和微服务培训")
				.termsOfServiceUrl("www.itmayiedu.com").version("0.0.1").build();
	}

}