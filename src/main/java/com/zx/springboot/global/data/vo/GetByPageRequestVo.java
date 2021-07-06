package com.zx.springboot.global.data.vo;


import com.zx.springboot.global.JsonParse;
import com.zx.springboot.utils.util.constants.ApiDesc;

public class GetByPageRequestVo extends JsonParse {

    @ApiDesc(value= "对应的数据列表的主键属性,用于操作删除,修改 ")
    private long id;
    @ApiDesc(value= "分页请求使用,对应为页码: 1,2,3 ...; 0/1 都是1")
    private int pageNo;
    @ApiDesc(value= "分页请求使用,对应为大小:默认是100,超过100条的接口需要重写page的方法")
    private int pageSize;
    @ApiDesc(value= "返回分页结果指定对象的聚合 ")
    private int type;
    /** status */
    @ApiDesc(value= "对应的数据列表的状态属性: 1.上架(显示), 0.下架(不显示/删除) ")
    private int status;
    /** sort */
    @ApiDesc(value= "对应的数据列表的排序属性 ")
    private int sort;
    @ApiDesc(value= "平台 ")
    private int platform ;

    public long getId() {
        return id;
    }

    public  <T extends GetByPageRequestVo> T  setId(long id) {
        this.id = id;
        return (T) this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public <T extends GetByPageRequestVo> T setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return (T) this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public <T extends GetByPageRequestVo> T setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return (T)this;
    }

    public int getType() {
        return type;
    }

    public <T extends GetByPageRequestVo> T  setType(int type) {
        this.type = type;
        return (T)this;
    }





    public int getStatus() {
        return status;
    }

    public <T extends GetByPageRequestVo> T  setStatus(int status) {
        this.status = status;
        return (T)this;
    }

    public int getSort() {
        return sort;
    }

    public <T extends GetByPageRequestVo> T  setSort(int sort) {
        this.sort = sort;
        return (T)this;
    }

    public int getPlatform() {
        return platform;
    }

    public <T extends GetByPageRequestVo> T  setPlatform(int platform) {
        this.platform = platform;
        return (T)this;
    }

}
