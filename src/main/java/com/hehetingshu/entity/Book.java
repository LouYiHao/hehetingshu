package com.hehetingshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hehetingshu.util.DateSerializable;

public class Book {
    private Integer bookid;

    private String bookimg;

    private String bookname;

    @Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookimg=" + bookimg
				+ ", bookname=" + bookname + ", cfid=" + cfid + ", booktime="
				+ booktime + ", uid=" + uid + "]";
	}

	private Integer cfid;
	// date转成字符串,后台返回前台数据
		@JsonSerialize(using = DateSerializable.class)
		// 前台传递一个字符串,后台接收日期类型
		@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date booktime;

    private Integer uid;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg == null ? null : bookimg.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getCfid() {
        return cfid;
    }

    public void setCfid(Integer cfid) {
        this.cfid = cfid;
    }

    public Date getBooktime() {
        return booktime;
    }

    public void setBooktime(Date booktime) {
        this.booktime = booktime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}