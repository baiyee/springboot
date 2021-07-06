package com.zx.springboot.global.data.vo;


import com.zx.springboot.global.JsonParse;
import com.zx.springboot.utils.util.constants.ApiDesc;

import java.util.List;

public class GetByIdRequestVo extends JsonParse {

    @ApiDesc(value= "对应的数据列表的主键属性,用于操作删除,修改 " )
    private long id;
    @ApiDesc(value= "对应的数据列表的主键列表聚合,使用char k = 7,分隔的字符口串; ")
    private List<Long> idList;
    @ApiDesc(value= "与idList对应的数据一一对应的排序数据值的集合;,使用char k = 7,分隔的字符口串;")
    private List<Integer> sortList;

    public long getId() {
        return id;
    }




    public List<Integer> getSortList() {
        return sortList;
    }

    public GetByIdRequestVo setSortList(List<Integer> sortList) {
        this.sortList = sortList;
        return this;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public GetByIdRequestVo setIdList(List<Long> idList) {
        this.idList = idList;
        return this;
    }
}
