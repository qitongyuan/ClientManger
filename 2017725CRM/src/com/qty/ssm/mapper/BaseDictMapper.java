package com.qty.ssm.mapper;

import java.util.List;

import com.qty.ssm.pojo.BaseDict;

public interface BaseDictMapper {
	/*
	 * 根据类别代码查询数据
	 */
	public List<BaseDict> selectByTypecode(String typecode);

}
