package com.hehetingshu.entity;

import java.util.List;

   /**
    * classification 实体类
    * Fri Nov 30 15:13:49 GMT+08:00 2018 娄轶豪
    */ 


public class Classification{
	
	@Override
	public String toString() {
		return "Classification [listbook=" + listbook + ", cfid=" + cfid
				+ ", cfname=" + cfname + "]";
	}
	private List<Book> listbook;
	public List<Book> getListbook() {
		return listbook;
	}
	public void setListbook(List<Book> listbook) {
		this.listbook = listbook;
	}
	private String cfid;
	private String cfname;
	public void setCfid(String cfid){
	this.cfid=cfid;
	}
	public String getCfid(){
		return cfid;
	}
	public void setCfname(String cfname){
	this.cfname=cfname;
	}
	public String getCfname(){
		return cfname;
	}
}

