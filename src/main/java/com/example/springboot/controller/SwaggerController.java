/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.example.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明: <br>
 * 创建作者:每特教育-余胜军<br>
 * 创建时间:2018年9月13日 下午4:16:46<br>
 * 教育机构:每特教育|蚂蚁课堂<br>
 * 版权说明:上海每特教育科技有限公司版权所有<br>
 * 官方网站:www.itmayiedu.com|www.meitedu.com<br>
 * 联系方式:qq644064779<br>
 * 注意:本内容有每特教育学员共同研发,请尊重原创版权
 */
@Api("swaggerDemo控制器")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

	@ApiOperation("swagger演示接口")
	@GetMapping("/index")
	public String index() {
		return "swagger index!";
	}

	@ApiOperation("获取swagger Api调用")
	@ApiImplicitParam(name = "swaggerName",value = "请求参数",required = true,dataType = "String")
	@PostMapping("/getSwaggerApi")
	public String getSwaggerApi(String firstName) {
		System.out.println("firstName:"+ firstName);
		return firstName;
	}
}
