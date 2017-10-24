package com.alex.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alex.pojo.BaseInfo;

@Repository
public interface BaseInfoDao {
	/**
	 * 添加新的博客
	 * 
	 * @param info
	 *            博客基本信息
	 * @return 还不清除是什么
	 */
	public int addBlog(BaseInfo info);

	/**
	 * 通过id查询基本信息
	 * 
	 * @param id
	 *            单条id号
	 * @return 整个BaseInfo对象
	 */
	public BaseInfo selectById(@Param("id") int id);

}
