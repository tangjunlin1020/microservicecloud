package com.tangjunlin.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003_App
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaServer7003_App.class,args);
        System.out.println( "EnableEurekaServer启动成功！！！！" );
    }
}
