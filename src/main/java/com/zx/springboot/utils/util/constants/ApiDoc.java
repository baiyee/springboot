package com.zx.springboot.utils.util.constants;

import java.lang.annotation.*;

/**
 * @author zhangxuan
 * @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
 *     @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
 * ---------------------

 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Documented//说明该注解将被包含在javadoc中  
public @interface ApiDoc {

    String module() default "接口类说明"; //java类描述；
    String value() default "接口说明"; //属性描述；
    String  author() default "作者"; //作者名称;
    boolean isApp() default false; //； 是否是app前端业务接口
    Class<?> request() default Object.class;
    Class<?>[] response() default Object.class;//返回结果实现类

}





