package com.tangjunlin.springcloud.cfgbeans;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{ 
	@Bean
	@LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean//如果不写下面的也可以，不写就是默认的轮询
	public IRule myRule()
	{
		return new RoundRobinRule();//默认的轮询算法，不写就是默认
//		return new RandomRule();//随机。达到的目的，用我们重新选择的随机算法替代默认的轮询。
//		return new RetryRule();//重试。先按照轮询策略获取服务，如果获取的服务失败则在指定指定时间内进行重试，获取可用的服务
	}
}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.tangjunlin.tmall.UserServiceImpl">