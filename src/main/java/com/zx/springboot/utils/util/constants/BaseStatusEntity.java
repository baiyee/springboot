package com.zx.springboot.utils.util.constants;


import com.zx.springboot.global.enums.TbStatusEnum;

/**
 * @author zhangxuan
 * @version V1.0
 * @Title: BaseEnter.java
 * @date 2016年2月20日
 * @Description: TODO(说明)
 * 所有表对象类都必须继承该类;
 */

public class BaseStatusEntity extends BaseEntity {


    private static final long serialVersionUID = -5102197522565173272L;


    private int status = TbStatusEnum.ENABLE.index(); //创建时间;
    private int sort ; //修改时间;


    public BaseStatusEntity() {
        super();
    }

    public static BaseStatusEntity build() {
        return new BaseStatusEntity();
    }

    public static BaseStatusEntity build(long id, int sort) {
        BaseStatusEntity build = build().setSort(sort);
        build.setSort(sort).setId(id);
        return build;
    }

//    public  <T extends BaseStatusEntity > T clone(Object source) {
//        BeanUtil.copyProperties(source, this);
//        return (T)this;
//    }



    public int getStatus() {
        return status;
    }

    public <T extends BaseStatusEntity > T setStatus(int status) {
        this.status = status;
        return (T)this;
    }

    public int getSort() {
        return sort;
    }

    public <T extends BaseStatusEntity > T setSort(int sort) {
        this.sort = sort;
        return (T)this;
    }
}
