package com.tangjunlin.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说
 * 我们达不到特殊化定制的目的了。
 */
@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
		//return new RandomRule();// Ribbon默认是轮询，我自定义为随机
		//return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
		
		return new RandomRule_ZY();// 我自定义为每台机器5次
	}
}
