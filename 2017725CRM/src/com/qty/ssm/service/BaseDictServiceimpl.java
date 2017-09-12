package com.qty.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qty.ssm.mapper.BaseDictMapper;
import com.qty.ssm.pojo.BaseDict;

@Service
public class BaseDictServiceimpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> selectByTypecode(String typecode) {
		// TODO Auto-generated method stub
		return baseDictMapper.selectByTypecode(typecode);
	}

}
