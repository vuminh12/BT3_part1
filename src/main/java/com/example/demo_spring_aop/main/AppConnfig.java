package com.example.demo_spring_aop.main;


import com.example.demo_spring_aop.aspect.*;
import com.example.demo_spring_aop.aspect_customer.CustomerAspect;
import com.example.demo_spring_aop.model.Customer;
import com.example.demo_spring_aop.model.Employee;
import com.example.demo_spring_aop.service.CustomerService;
import com.example.demo_spring_aop.service.EmployeeService;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import java.util.List;


// anotation đánh dấu 1 là 1 file  cấu hình
@Configuration
@Aspect
// anotation @EnableAspectAutoProxy đi kèm với @Configuration, hỗ trọ xử lý các thành phần được đánh dấu bằng @Aspect
@EnableAspectJAutoProxy
public class AppConnfig {

    // đánh dấu 1 bean,set name giống tên trong spring.xml
    @Bean
    public Employee employee(){
        Employee employee = new Employee();
        employee.setName("Dummy Name");
        return employee;
    }

    // đánh đấu 1 bean, tạo 1 đối tượng EmployeeService và add 1 Employee trong spring.xml
    @Bean
    public EmployeeService employeeService(Employee employee){
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployee(employee);
        return employeeService;
    }

    // Bean của class EmployeeAspect
    @Bean
    public EmployeeAspect callEmployeeAspect(){
        EmployeeAspect employeeAspect = new EmployeeAspect();
        return employeeAspect;
    }

    //đánh dấu bean của EmployeeAfterAspect
    @Bean
    public EmployeeAfterAspect callEmployeeAfterAspect(){
        EmployeeAfterAspect employeeAfterAspect = new EmployeeAfterAspect();
        return employeeAfterAspect;
    }

    // đánh dấu bean của EmployeeAnnotationAspect
    @Bean
    public EmployeeAnnotationAspect callEmployeeAnnotationAspect(){
        EmployeeAnnotationAspect employeeAnnotationAspect = new EmployeeAnnotationAspect();
        return employeeAnnotationAspect;
    }

    // đánh dấu bean của EmployeeAroundAspect
    @Bean
    public EmployeeAroundAspect callEmployeeAroundAspect(){
        EmployeeAroundAspect employeeAroundAspect = new EmployeeAroundAspect();
        return employeeAroundAspect;
    }

    // đánh dấu bean của EmployeeAspectJoinPoint
    @Bean
    public EmployeeAspectJoinPoint callEmployeeAspectJoinPoint(){
        EmployeeAspectJoinPoint employeeAspectJoinPoint = new EmployeeAspectJoinPoint();
        return employeeAspectJoinPoint;
    }

    // đánh dấu bean của EmployeeAspectPointcut
    @Bean
    public EmployeeAspectPointcut callEmployeeAspectPointcut(){
        EmployeeAspectPointcut employeeAspectPointcut = new EmployeeAspectPointcut();
        return employeeAspectPointcut;
    }

    // đánh dấu bean của EmployeeXMLConfigAspect
    @Bean
    public EmployeeXMLConfigAspect callEmployeeXMLConfigAspect(){
        EmployeeXMLConfigAspect employeeXMLConfigAspect = new EmployeeXMLConfigAspect();
        return employeeXMLConfigAspect;
    }

    // đánh dấu 1 bean CustomerService khi gọi phương thức xóa 1 đối tượng customer
    @Bean
    public CustomerService deleteCustomerAspect(Customer customer){
        CustomerService customerService = new CustomerService();
        // gọi phương thức deleteCustomerById() xóa 1 đối tượng trong serivce
          customerService.deleteCustomerById(customer.getId());
          return customerService;
    }

    // đánh dấu 1 bean CustomerService khi phương thức tạo mới 1 đối tượng customer
    @Bean
    public CustomerAspect postCustomerAspect(){
        CustomerAspect customerAspect = new CustomerAspect();
        customerAspect.createCustomerAdvice();
        return customerAspect;
    }

    //đánh dấu 1 bean CustomerService khi phương thức lấy tất cả đối tượng customer
    @Bean
    public CustomerAspect getCustomerAspect(){
        CustomerAspect customerAspect = new CustomerAspect();
        customerAspect.getAllCustomerAdvice();
        return customerAspect;
    }

    // đánh dấu 1 bean CustomerService khi phương thức lấy 1 đối tượng customer theo id
    @Bean
    public CustomerAspect getCustomerByIdAspect(){
        CustomerAspect customerAspect = new CustomerAspect();

        customerAspect.getCustomerByIdAdvice();
        return customerAspect;
    }

    // bean tạo mới 1 đối tượng customer
    @Bean
    public Customer customer(){
        Customer customer = new Customer();
        customer.setEmail("vuvanminh0608@gmail.com");
        customer.setAge(25);
        customer.setId(1);
        customer.setName("Vũ Văn Minh");
        System.out.println("loading create customer");
        return customer;
    }

    // customer tạo mới 1 đối tượng customerService
    @Bean
    public CustomerService customerService(List<Customer> customers){
        CustomerService customerService = new CustomerService();
        customers.add(customer());
        customerService.setCustomers(customers);
        System.out.println("loading create customerService! ");
        return customerService;
    }
}
