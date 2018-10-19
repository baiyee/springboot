package com.example.springboot.model;
/**
 * 分页Model
 * 
 * @author lujinfu
 * @date 2018年6月15日
 */
public class Page {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalCount;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getSqlIndex(){
		return (pageIndex!=null&&pageSize!=null)?((pageIndex - 1)*pageSize):null;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
