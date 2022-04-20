package com.tangjunlin.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tangjunlin.springcloud.entities.Dept;
import com.tangjunlin.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service = null;

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")//一旦调用服务方法失败并抛出错误信息后，会自动调用processHystrix_Get方法。这种方式不太好，容易代码冗余，使用fallbackFactory在接口上写熔断器与主程序解耦
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept =  this.service.get(id);
		if(null == dept)
		{
			throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id)
	{
		return new Dept().setDeptno(id)
				.setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
}

