package com.mybatis.example.demomybatis.service.mapper;

import com.mybatis.example.demomybatis.service.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Results({
            @Result(property = "customer_id", column = "CUSTOMER_ID"),
            @Result(property = "customer_name", column = "CUSTOMER_NAME"),
            @Result(property = "location_id", column = "LOCATION_ID"),
    })
    @Select("select CUSTOMERS.CUSTOMER_ID, CUSTOMERS.CUSTOMER_NAME,CUSTOMERS.LOCATION_ID from CUSTOMERS")
    List<Customer> fetchCustomers();



    @Insert("INSERT into CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,LOCATION_ID) values(#{customer_id},#{customer_name},#{location_id})")
    @SelectKey(statement = "SELECT CUSTOMER_SEQUENCE.NEXTVAL from dual", keyProperty = "customer_id",
            before = true, resultType = Integer.class)
    int insert(Customer c);

}

//    @Insert("INSERT into CUSTOMERS(CUSTOMER_NAME,ZIP_CODE) values(#{CUSTOMER_NAME},#{ZIP_CODE})")
//    @SelectKey(statement = "SELECT CUSTOMER_SEQUENCE.NEXTVAL", keyProperty = "CUSTOMER_ID",
//            before = true, resultType = Integer.class)
//    int insert(Customer c);