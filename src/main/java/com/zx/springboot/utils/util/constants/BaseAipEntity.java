package com.zx.springboot.utils.util.constants;

import com.zx.springboot.global.data.api.IBaseApi;
import com.zx.springboot.utils.util.bean.BeanUtil;

public class BaseAipEntity implements IBaseApi {
    @Override
    public <T extends IBaseApi> T clone(Object source) {
        BeanUtil.copyProperties(source, this);
        return (T)this;
    }
}
