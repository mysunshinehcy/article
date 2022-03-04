package com.hcy.pagenation;

public class PagenationU<T> {

	private int currentPage;
	
	private int startIndex;
	private int endIndex;
	private int count = 10;
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = (currentPage-1)* count;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex =  currentPage * count;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PagenationU() {
		
	}

}
