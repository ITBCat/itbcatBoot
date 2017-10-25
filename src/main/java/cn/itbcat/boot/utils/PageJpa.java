package cn.itbcat.boot.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public class PageJpa<T> {
	private int pageNumber;
	private int pageSize;
	private String sortName;
	private String sortOrder;
	private T obj;
	
	private long total;
	private List<T> rows;
	
	@JsonIgnore
	public PageRequest getPageable(){
		PageRequest pageable = null;
		if(StringUtils.isEmpty(sortName) == false){
			pageable = new PageRequest(pageNumber-1,
					pageSize,
					"desc".equals(sortOrder)? Direction.DESC: Direction.ASC,sortName) ;
		}else{
			pageable = new PageRequest(pageNumber-1,
					pageSize) ;
		}
		return pageable;
	}
	
	@JsonIgnore
	public <E> PageJpa<E> getData(JpaSpecificationExecutor<E> jpa, Specification<E> spec){
		PageJpa<E> page = new PageJpa<E>();
		Page<E> p = jpa.findAll(spec, this.getPageable());
		if(p != null){
			page.total = p.getTotalElements();
			page.rows = p.getContent();
		}
		return page;
	}
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public long getTotal() {
		return total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	
	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getSortName() {
		return sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageJpa [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", sortName=" + sortName
				+ ", sortOrder=" + sortOrder + ", obj=" + obj + ", total=" + total + ", rows=" + rows + "]";
	}
}
