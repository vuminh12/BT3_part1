package com.example.demo_spring_aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.junit.After;

// khai báo anotation để cắt class cần thiết
@Aspect
public class EmployeeAfterAspect {


	// args: đối số dòng lệnh, mảng các đối tượng name
	@After
	public void logStringArguments(String name){
		System.out.println("Running After Advice. String argument passed=" +name);
	}


	@AfterThrowing("within(com.example.demo_spring_aop.model.Employee)")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("Exception thrown in Employee Method="+joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("getNameReturningAdvice executed. Returned String="+returnString);
	}
	
}
