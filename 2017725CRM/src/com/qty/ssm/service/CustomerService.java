package com.qty.ssm.service;

import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;
import com.qty.ssm.util.Page;

public interface CustomerService {
	/*
	 * 根据条件分页查询
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo)throws Exception;
	
	/*
	 * 根据ID查询用户
	 */
	public Customer queryCustomerById(Long id)throws Exception;
	
	/*
	 * 根据ID编辑客户数据
	 */
	public void updateCustomerById(Customer customer)throws Exception;
	
	/*
	 * 根据ID删除客户
	 */
	public void deleteCustomerById(Long id)throws Exception;

}
