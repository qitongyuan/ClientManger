package com.qty.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qty.ssm.pojo.BaseDict;
import com.qty.ssm.pojo.Customer;
import com.qty.ssm.pojo.QueryVo;
import com.qty.ssm.service.BaseDictService;
import com.qty.ssm.service.CustomerService;
import com.qty.ssm.util.Page;

/*
 * ��ʾ�ͻ��б�
 */


@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${fromType.code}")
	private String fromTypecode;
	@Value("${industryType.code}")
	private String IndustryTypecode;
	@Value("${levelType.code}")
	private String levelTypecode;
	
	//���
	@RequestMapping(value="/customer/list")
	public String list(QueryVo queryVo, Model model) throws Exception{
		
		List<BaseDict> fromType = baseDictService.selectByTypecode(fromTypecode);
		List<BaseDict> industryType = baseDictService.selectByTypecode(IndustryTypecode);
		List<BaseDict> levelType = baseDictService.selectByTypecode(levelTypecode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//��ҳ��ѯ����
		Page<Customer>page=customerService.queryCustomerByQueryVo(queryVo);
		//�ѷ�ҳ��ѯ�����ݷ���ģ����
		model.addAttribute("page",page);
		//���ݻ���
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());

		return "customer";
	}
	
	/*
	 * ����ID��ѯ�û�������JSON��ʽ����
	 */
	@RequestMapping("customer/edit")
	@ResponseBody
	public Customer queryCustomerById(long id)throws Exception{
		Customer customer=customerService.queryCustomerById(id);
		return customer;
	}
	/*
	 * ����id��ѯ�û�,���ظ��º�ͻ���json��ʽ����
	 */
	@RequestMapping("customer/update")
	@ResponseBody
	public String updateCustomerById(Customer customer)throws Exception{
		customerService.updateCustomerById(customer);
		return "OK";
		
	}
	
	/*
	 * ɾ���û�
	 */
	@RequestMapping("customer/delete")
	@ResponseBody
	public String deleteCustomerById(Long id)throws Exception{
		customerService.deleteCustomerById(id);
		return "OK";
		
	}

}
