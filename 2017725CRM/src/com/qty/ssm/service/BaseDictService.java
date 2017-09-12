package com.qty.ssm.service;

import java.util.List;

import com.qty.ssm.pojo.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> selectByTypecode(String typecode);

}
