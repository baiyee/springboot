package com.zx.springboot.global.data.vo;


import com.zx.springboot.utils.util.constants.ApiDesc;

import java.util.ArrayList;
import java.util.List;


/**   
 * @Title: RespFriendShipList.java 
 * @author zhangxuan
 * @date   2017年1月19日
 * @version V1.0  
 * @Description: TODO(说明)  
 */

public class ResponseResultList<T> {
    @ApiDesc(value= "返回分页结果指定对象的聚合 ")
	private List<T> list;
    @ApiDesc(value= "是否有下一页,1.有下一页,0:没有下一页")
	private int isNextPage;
    @ApiDesc(value= "下一页的开始索引的表ID值,类型为long")
	private long pageIndex;

	public static ResponseResultList build( ){
		return new ResponseResultList();
	}
	
	public ResponseResultList( ) {
		list = new ArrayList<>();
	}
	
	public ResponseResultList(int isNextPage) {
		super();
		this.isNextPage = isNextPage;
		list = new ArrayList<>();
	}
	
	public int getIsNextPage() {
		return isNextPage;
	}
	public ResponseResultList setIsNextPage(int isNextPage) {
		this.isNextPage = isNextPage;
		return this;
	}
    public ResponseResultList setIsNextPage(boolean isNextPage) {
        int nextPage = isNextPage == true ? 1 : 0;
        this.isNextPage = nextPage;
        return this;
    }

	public List<T> getList() {
		return list;
	}

    public ResponseResultList setList(List<T> list) {
		if(list != null){
			this.list = list;
		}
		return this;
    }
	

    public long getPageIndex() {
        return pageIndex;
    }

    public ResponseResultList setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }
}
