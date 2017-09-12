package com.qty.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qty.ssm.mapper.CustomerMapper;
import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;
import com.qty.ssm.util.Page;
@Service
public class CustomerServiceimpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) throws Exception {
		// TODO Auto-generated method stub
		
		if (null!=queryVo.getPage()) {
			//设置查询条件，从哪一条数据开始查起
			queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		}
		//查询数据结果集
		List<Customer>list=customerMapper.queryCustomerByQueryVo(queryVo);
		//查询到的总条数
		int total=customerMapper.queryCountByQueryVo(queryVo);
		Page<Customer>page=new Page<>(total,queryVo.getPage(),queryVo.getRows(),list);
		return page;
		
	}
/*
 * 根据ID查询用户用于回显(non-Javadoc)
 * @see com.qty.ssm.service.CustomerService#queryCustomerById(java.lang.Long)
 */
	@Override
	public Customer queryCustomerById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Customer customer=customerMapper.queryCustomerById(id);
		return customer;
	}
	/*
	 * 根据ID编辑用户信息
	 */
	@Override
	public void updateCustomerById(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		customerMapper.updateCustomerById(customer);
		
	}
	
	/*
	 * 删除用户(non-Javadoc)
	 * @see com.qty.ssm.service.CustomerService#deleteCustomerById(java.lang.Long)
	 */
	@Override
	public void deleteCustomerById(Long id) throws Exception {
		customerMapper.deleteCustomerById(id);
		
	}

}
