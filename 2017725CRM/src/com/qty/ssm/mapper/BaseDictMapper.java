package com.qty.ssm.mapper;

import java.util.List;

import com.qty.ssm.pojo.BaseDict;

public interface BaseDictMapper {
	/*
	 * �����������ѯ����
	 */
	public List<BaseDict> selectByTypecode(String typecode);

}
