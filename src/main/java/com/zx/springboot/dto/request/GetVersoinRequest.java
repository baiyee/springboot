package com.zx.springboot.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
 * 项目名称：mybitt
 * 类名称：GetVersoinRequest
 * 类描述：   获取版本号
 * 创建人：wangtelong
 * 创建时间：2018年2月9日 下午11:04:04
 * 修改人：wangtelong
 * 修改时间：2018年2月9日 下午11:04:04
 * 修改备注：
 */
public class GetVersoinRequest {
    @NotEmpty(message = "{request.param.notempty.system}")
    @NotNull(message = "{request.param.notempty.system}")
    private String system;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
