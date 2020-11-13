package com.example.demo_spring_aop.main;//package springaop.demo_spring_aop.main;

import com.example.demo_spring_aop.service.CustomerService;
import com.example.demo_spring_aop.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

	public static  void main(String[] args) {
		// khởi tạo 1 application context config = anotation
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// đăng kí AppConfig.class có thể sử dụng anotation
		ctx.register(AppConnfig.class);
		ctx.refresh();

		// Employee
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		System.out.println(employeeService.getEmployee().getName());
		employeeService.getEmployee().setName("Pankaj");
		employeeService.getEmployee().throwException();

		// customer
		CustomerService customerService = ctx.getBean("customerService", CustomerService.class);

	}

}
