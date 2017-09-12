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
 * 显示客户列表
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
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo queryVo, Model model) throws Exception{
		
		List<BaseDict> fromType = baseDictService.selectByTypecode(fromTypecode);
		List<BaseDict> industryType = baseDictService.selectByTypecode(IndustryTypecode);
		List<BaseDict> levelType = baseDictService.selectByTypecode(levelTypecode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//分页查询数据
		Page<Customer>page=customerService.queryCustomerByQueryVo(queryVo);
		//把分页查询的数据放入模型中
		model.addAttribute("page",page);
		//数据回现
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());

		return "customer";
	}
	
	/*
	 * 根据ID查询用户，返回JSON格式数据
	 */
	@RequestMapping("customer/edit")
	@ResponseBody
	public Customer queryCustomerById(long id)throws Exception{
		Customer customer=customerService.queryCustomerById(id);
		return customer;
	}
	/*
	 * 根据id查询用户,返回更新后客户的json格式数据
	 */
	@RequestMapping("customer/update")
	@ResponseBody
	public String updateCustomerById(Customer customer)throws Exception{
		customerService.updateCustomerById(customer);
		return "OK";
		
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping("customer/delete")
	@ResponseBody
	public String deleteCustomerById(Long id)throws Exception{
		customerService.deleteCustomerById(id);
		return "OK";
		
	}

}
