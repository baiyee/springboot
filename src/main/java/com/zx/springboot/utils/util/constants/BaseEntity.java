package com.zx.springboot.utils.util.constants;


import com.zx.springboot.utils.util.bean.BeanUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxuan
 * @version V1.0
 * @Title: BaseEnter.java
 * @date 2016年2月20日
 * @Description: TODO(说明)
 * 所有表对象类都必须继承该类;
 */

public abstract class BaseEntity implements Serializable {


    private static final long serialVersionUID = -5102197522565173276L;

    @ApiDesc(value =  "对应的主键值")
    private long id; //表主键id;
    //	private long globalId; //全局id 用于分表分库使用
    @ApiDesc(value =  "创建时间")
    private Date createDate; //创建时间;
    @ApiDesc(value =  "修改时间")
    private Date modifyDate; //修改时间;


    public BaseEntity() {
        super();
        this.modifyDate = this.createDate = new Date();
    }

    public  <T extends BaseEntity > T clone(Object source) {
        BeanUtil.copyProperties(source, this);
        return (T)this;
    }


    public BaseEntity initDate(){
        this.modifyDate = this.createDate = new Date();
        return this;
    }

    public long getId() {
        return id;
    }

    public String getEsId(){
        return String.valueOf(id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
//        if(null == createDate ){
//            createDate = new Date();
//        }
        return createDate;
    }


    public BaseEntity setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
//        if(null == modifyDate ){
//            modifyDate = new Date();
//        }
        return modifyDate;
    }


    public BaseEntity setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
