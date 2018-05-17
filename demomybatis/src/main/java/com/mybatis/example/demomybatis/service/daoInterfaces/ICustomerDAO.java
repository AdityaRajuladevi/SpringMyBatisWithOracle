package com.mybatis.example.demomybatis.service.daoInterfaces;

import com.mybatis.example.demomybatis.service.model.Customer;

import java.util.List;

public interface ICustomerDAO {

     boolean validateCustomer(Customer c);

     List<Customer> getAllCustomers();

     List<Customer> addCustomer(Customer c);

     Customer addandReturnCustomer(Customer c);
}
