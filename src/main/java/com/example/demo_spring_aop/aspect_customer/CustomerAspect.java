package com.example.demo_spring_aop.aspect_customer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// anotation đánh dấu nó là 1 class dùng để cắt đối tượng customer
@Aspect
public class CustomerAspect {

    //1. phương thức này sẽ chạy trước khi method deleteCustomerById() được gọi đến
    @Before("execution(public boolean com.example.demo_spring_aop.service.CustomerService.deleteCustomerById(*))")
    public void deleteByIdAdviceBefore(){
        System.out.println("Service method delete called");
    }

    // 2. phương thức này gọi sẽ chạy sau khi tất cả các phương thức bắt dầu bằng delete được gọi đến
    @After("execution(public boolean com.example.demo_spring_aop.service.CustomerService.delete*(*))")
    public void deleteByIdAdviceAfter(){
        System.out.println("Customer removed");
    }

    //3. phương thức gọi ra sau khi phương thức tạo mới 1 đói tượng được gọi ra
    @After("execution(* com.example.demo_spring_aop.service.CustomerService.postCustomer(*))")
    public  void createCustomerAdvice(){
        System.out.println("customer added");
    }

    // 4. phương thức này gọi ra sau khi phương thức lấy tất cả các đối tượng được gọi
    @After("execution(* com.example.demo_spring_aop.service.CustomerService.getCustomers())")
    public  void getAllCustomerAdvice(){
        System.out.println("customer getted all");
    }

    //5. phương thức này gọi ra sau khi phương thức lấy đối tượng theo id được gọi
    @After("execution(* com.example.demo_spring_aop.service.CustomerService.getCustomerById(*))")
    public void getCustomerByIdAdvice(){
        System.out.println("customer getted by Id");
    }

}
