package com.tangjunlin.springcloud.entities;

import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

//@Setter ：注解在类或字段，注解在类时为所有字段生成setter方法，注解在字段上时只为该字段生成setter方法。
//@Getter ：使用方法同上，区别在于生成的是getter方法。
//@ToString ：注解在类，添加toString方法。
//@EqualsAndHashCode： 注解在类，生成hashCode和equals方法。
//@NoArgsConstructor： 注解在类，生成无参的构造方法。
//@RequiredArgsConstructor： 注解在类，为类中需要特殊处理的字段生成构造方法，比如final和被@NonNull注解的字段。
//@AllArgsConstructor： 注解在类，生成包含类中所有字段（全参数）的构造方法。
//@Data： 注解在类，生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
//@Slf4j： 注解在类，生成log变量，严格意义来说是常量。


@NoArgsConstructor//生成一个无参数的构造方法
@Data//生成getter,setter ,toString等函数
@Accessors(chain=true)//使用链式的访问风格
public class Dept implements Serializable// entity --orm--- db_table
{
	private Long 	deptno; // 主键
	private String 	dname; // 部门名称
	private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(String dname)
	{
		super();
		this.dname = dname;
	}
	
}
