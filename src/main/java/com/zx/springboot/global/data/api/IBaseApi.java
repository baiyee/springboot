package com.zx.springboot.global.data.api;

public interface IBaseApi {

    public <T extends IBaseApi> T clone(Object source) ;
}
