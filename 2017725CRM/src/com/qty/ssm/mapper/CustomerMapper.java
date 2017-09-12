package com.qty.ssm.mapper;

import java.util.List;

import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;

public interface CustomerMapper {
	/*
	 * 根据queryVo分页查询数据
	 */
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVo) throws Exception;
	/*
	 * 根据queryVo查询数据条数
	 */
	public int queryCountByQueryVo(QueryVo queryVo)throws Exception;

	/*
	 * 根据ID查询客户，用于修改页面的数据回显示
	 */
	public Customer queryCustomerById(long id)throws Exception;
	
	/*
	 * 根据ID编辑客户
	 */
	public void updateCustomerById(Customer customer)throws Exception;
	
	/*
	 * 根据ID删除用户
	 */
	public void deleteCustomerById(Long id)throws Exception;
}
