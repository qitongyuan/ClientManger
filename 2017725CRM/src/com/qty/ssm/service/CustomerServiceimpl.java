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
			//���ò�ѯ����������һ�����ݿ�ʼ����
			queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		}
		//��ѯ���ݽ����
		List<Customer>list=customerMapper.queryCustomerByQueryVo(queryVo);
		//��ѯ����������
		int total=customerMapper.queryCountByQueryVo(queryVo);
		Page<Customer>page=new Page<>(total,queryVo.getPage(),queryVo.getRows(),list);
		return page;
		
	}
/*
 * ����ID��ѯ�û����ڻ���(non-Javadoc)
 * @see com.qty.ssm.service.CustomerService#queryCustomerById(java.lang.Long)
 */
	@Override
	public Customer queryCustomerById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Customer customer=customerMapper.queryCustomerById(id);
		return customer;
	}
	/*
	 * ����ID�༭�û���Ϣ
	 */
	@Override
	public void updateCustomerById(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		customerMapper.updateCustomerById(customer);
		
	}
	
	/*
	 * ɾ���û�(non-Javadoc)
	 * @see com.qty.ssm.service.CustomerService#deleteCustomerById(java.lang.Long)
	 */
	@Override
	public void deleteCustomerById(Long id) throws Exception {
		customerMapper.deleteCustomerById(id);
		
	}

}
