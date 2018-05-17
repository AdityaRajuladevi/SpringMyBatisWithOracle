package com.mybatis.example.demomybatis.service.mapper;

import com.mybatis.example.demomybatis.service.model.Customer;
import com.mybatis.example.demomybatis.service.model.FullCustomer;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FullCustomerMapper {

    @Results({
            @Result(property = "customer_id", column = "CUSTOMER_ID"),
            @Result(property = "customer_name", column = "CUSTOMER_NAME"),
            @Result(property = "location_id", column = "LOCATION_ID"),
            @Result(property = "street_address", column = "STREET_ADDRESS"),
            @Result(property = "postal_code", column = "POSTAL_CODE"),
            @Result(property = "city", column = "CITY"),
            @Result(property = "state_province", column = "STATE_PROVINCE"),
            @Result(property = "country_id", column = "COUNTRY_ID")
    })
    @Select("SELECT CUSTOMERS.CUSTOMER_ID, CUSTOMERS.CUSTOMER_NAME, CUSTOMERS.LOCATION_ID," +
            " LOCATION.STREET_ADDRESS, LOCATION.POSTAL_CODE , LOCATION.CITY, LOCATION.STATE_PROVINCE, LOCATION.COUNTRY_ID  from CUSTOMERS, LOCATION " +
            "where LOCATION.LOCATION_ID = CUSTOMERS.LOCATION_ID")
    List<FullCustomer> getCustomers();
}
