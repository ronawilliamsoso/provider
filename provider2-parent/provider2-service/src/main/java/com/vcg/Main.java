package com.vcg;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication 
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		//pid 方便 用kill关闭
//		String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
//		FileWriter writer=new FileWriter(new File("provider.pid")); 
//		writer.write(name);
//		writer.close();
		
		SpringApplication.run(Main.class,args);
	}
	
	//67074638
	
	
}