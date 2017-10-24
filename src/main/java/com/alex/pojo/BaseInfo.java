package com.alex.pojo;

/**
 * 每篇博客基本信息
 * 
 * @author AlexZHOU
 * @since 2017.9.8
 * @version 0.1
 */
public class BaseInfo {

	/**
	 * 博客对应的id号
	 */
	private int id;

	/**
	 * 博客标题
	 */
	private String title;

	/**
	 * 博客标签
	 */
	private String[] tag;

	/**
	 * 博客存放位置
	 */
	private String path;
	
	private String synopsis;

	private String data;
	
	public BaseInfo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
