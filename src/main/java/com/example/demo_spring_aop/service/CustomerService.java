package com.example.demo_spring_aop.service;


import com.example.demo_spring_aop.aspect.Loggable;
import com.example.demo_spring_aop.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerService {
    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        // Initialize Data
        Customer customer = new Customer( 1,"Nguyen Van A","a@gmail.com",30);
        Customer customer1 = new Customer( 2,"Nguyen Van B","b@gmail.com",33);
        Customer customer2 = new Customer( 3,"Nguyen Van C","c@gmail.com",34);
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
    }

    //post customer
    @Loggable
    public Customer postCustomer(Customer customer) {
        int idCustomerEnd = customers.get(customers.size() - 1).getId();
        customer.setId(idCustomerEnd + 1);
        customers.add(customer);
        return customer;
    }

    // get customer
    public List<Customer> getCustomers(){
        return customers;
    }

    //get customer by id
    public Customer getCustomerById(Integer id){
        for(Customer customer : customers){
            if(id.equals(customer.getId())){
                return customer;
            }
        }
        return null;
    }

    // delete customer by id
    public Boolean deleteCustomerById(Integer id){
        for(Customer customer : customers){
            if(customer.getId()==(id)){
                customers.remove(customer);
                return true;
            }

        }
        return false;
    }

    public static void setCustomers(List<Customer> customers) {
        CustomerService.customers = customers;
    }
}
