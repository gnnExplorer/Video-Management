package com.zhiyou100.vm.model;

import java.util.List;

import com.zhiyou100.vm.util.Page;

public class CSVVo {
	
	private List<Course> cl;
	private List<Speaker>sl;
	private List<Video> vl;
	private Page<Video> page;
	private String keyword;
	private String speakerName;
	private String courseName;
	private Integer currentPage;
	private Integer begin;
	
	
	
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Page<Video> getPage() {
		return page;
	}
	public void setPage(Page<Video> page) {
		this.page = page;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<Course> getCl() {
		return cl;
	}
	public void setCl(List<Course> cl) {
		this.cl = cl;
	}
	public List<Speaker> getSl() {
		return sl;
	}
	public void setSl(List<Speaker> sl) {
		this.sl = sl;
	}
	public List<Video> getVl() {
		return vl;
	}
	public void setVl(List<Video> vl) {
		this.vl = vl;
	}
	@Override
	public String toString() {
		return "CSVVo [cl=" + cl + ", sl=" + sl + ", vl=" + vl + ", page=" + page + ", keyword=" + keyword
				+ ", speakerName=" + speakerName + ", courseName=" + courseName + ", currentPage=" + currentPage
				+ ", begin=" + begin + "]";
	}
	
	
	

}
