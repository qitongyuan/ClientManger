package com.qty.ssm.mapper;

import java.util.List;

import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;

public interface CustomerMapper {
	/*
	 * ����queryVo��ҳ��ѯ����
	 */
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVo) throws Exception;
	/*
	 * ����queryVo��ѯ��������
	 */
	public int queryCountByQueryVo(QueryVo queryVo)throws Exception;

	/*
	 * ����ID��ѯ�ͻ��������޸�ҳ������ݻ���ʾ
	 */
	public Customer queryCustomerById(long id)throws Exception;
	
	/*
	 * ����ID�༭�ͻ�
	 */
	public void updateCustomerById(Customer customer)throws Exception;
	
	/*
	 * ����IDɾ���û�
	 */
	public void deleteCustomerById(Long id)throws Exception;
}
