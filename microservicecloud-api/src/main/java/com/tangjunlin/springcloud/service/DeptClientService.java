package com.tangjunlin.springcloud.service;
import java.util.List;

import com.tangjunlin.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * 
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author tangjunlin
 * @date 2018年4月21日
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory= com.tangjunlin.springcloud.service.DeptClientServiceFallbackFactory.class)//fallbackFactory是为了做服务降级的
public interface DeptClientService
{
	//RequestMapping的value一定要和provider的一样。否则调用不了。method可以不写
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
