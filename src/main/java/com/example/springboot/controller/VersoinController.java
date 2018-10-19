package com.example.springboot.controller;


import com.example.springboot.contants.Constant;
import com.example.springboot.contants.ConstantEnum;
import com.example.springboot.dto.request.GetVersoinRequest;
import com.example.springboot.dto.request.VersoinRequest;
import com.example.springboot.dto.response.ReturnMessage;
import com.example.springboot.dto.response.VersoinResponse;
import com.example.springboot.model.Versoin;
import com.example.springboot.service.VersoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sea123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/versoin")
public class VersoinController {

    @Autowired
    private VersoinService mVersoinService;

    @RequestMapping(value = "/getVersoin", method = RequestMethod.POST)
    public ReturnMessage getVersoin(@RequestBody @Validated GetVersoinRequest requestBody) throws Throwable {
        Versoin versoin = mVersoinService.searchVersoinInfoWithSystem(requestBody.getSystem());
        return new ReturnMessage(ReturnMessage.SUCCESS, ConstantEnum.SUCCESS.getCode(),  ConstantEnum.SUCCESS.getCnDetail(), versoin);
    }

    @RequestMapping(value = "/add")
    public ReturnMessage add(HttpServletRequest httpRequest,
                             @RequestBody @Valid VersoinRequest versoinRequest) throws Exception {
        String locale = httpRequest.getHeader(Constant.LOCALE);
        if (StringUtils.isEmpty(locale)) {
            locale = Constant.EN_US;
        }
        versoinRequest.setLocale(locale);
        Boolean result = mVersoinService.addVersoin(versoinRequest);
        return new ReturnMessage(ReturnMessage.SUCCESS, ConstantEnum.SUCCESS.getCode(),
                ConstantEnum.SUCCESS.getCnDetail(),result);
    }

    /**
     * 根据id 删除版本记录信息
     * @param versoinId
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public ReturnMessage delete(@PathVariable(value = "id") Long versoinId) {
        if (StringUtils.isEmpty(versoinId)) {
            return new ReturnMessage(ReturnMessage.ERROR, ConstantEnum.ERROR.getCode(),
                    "版本记录id不能为空", null);
        }
        Boolean result = mVersoinService.deleteAllById(versoinId);
        return new ReturnMessage(ReturnMessage.SUCCESS,ConstantEnum.SUCCESS.getCode(),
                ConstantEnum.SUCCESS.getCnDetail(),result);
    }

    @RequestMapping(value = "/update")
    public ReturnMessage update(@RequestBody VersoinRequest request) {
        if (StringUtils.isEmpty(request.getId())) {
            return new ReturnMessage(ReturnMessage.ERROR, ConstantEnum.ERROR.getCode(),
                    "版本记录id不能为空", null);
        }
        Boolean result = mVersoinService.updateAllById(request);
        return new ReturnMessage(ReturnMessage.SUCCESS,ConstantEnum.SUCCESS.getCode(),
                ConstantEnum.SUCCESS.getCnDetail(),result);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public ReturnMessage getVersoin(@RequestBody VersoinRequest request) throws Throwable {
        VersoinResponse response = mVersoinService.selectVsrsoinList(request);
        return new ReturnMessage(ReturnMessage.SUCCESS, ConstantEnum.SUCCESS.getCode(),  ConstantEnum.SUCCESS.getCnDetail(), response);
    }
}

