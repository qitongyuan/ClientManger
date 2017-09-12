package com.qty.ssm.service;

import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;
import com.qty.ssm.util.Page;

public interface CustomerService {
	/*
	 * ����������ҳ��ѯ
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo)throws Exception;
	
	/*
	 * ����ID��ѯ�û�
	 */
	public Customer queryCustomerById(Long id)throws Exception;
	
	/*
	 * ����ID�༭�ͻ�����
	 */
	public void updateCustomerById(Customer customer)throws Exception;
	
	/*
	 * ����IDɾ���ͻ�
	 */
	public void deleteCustomerById(Long id)throws Exception;

}
