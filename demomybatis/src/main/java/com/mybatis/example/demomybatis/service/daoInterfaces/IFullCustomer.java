package com.mybatis.example.demomybatis.service.daoInterfaces;

import com.mybatis.example.demomybatis.service.model.FullCustomer;

import java.util.List;

public interface IFullCustomer {

    List<FullCustomer> getAllCustomerDetails();

    FullCustomer insertFullCustomer(FullCustomer customer);
}
