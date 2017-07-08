package kami.gdufe.model;

public class PageBean {
	private Integer pageSize = 10;
	private Integer pageNow;
	private Integer totalCount;
	private Integer totalPage;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		setTotalPage(totalCount);
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalCount) {
		this.totalPage = (totalCount  +  pageSize  - 1) / pageSize; ;
	}

}
