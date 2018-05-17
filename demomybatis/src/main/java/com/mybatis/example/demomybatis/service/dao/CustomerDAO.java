package com.mybatis.example.demomybatis.service.dao;

import com.mybatis.example.demomybatis.service.daoInterfaces.ICustomerDAO;
import com.mybatis.example.demomybatis.service.model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerDAO implements ICustomerDAO{

    private SqlSession sqlSession;

    public CustomerDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.sqlSession.selectList("fetchCustomers");
    }

    @Override
    public List<Customer> addCustomer(Customer c) {
        try {

            this.sqlSession.insert("insert", c);
            System.out.println("Primary key"+ c.getCustomer_id());
        }catch(org.springframework.dao.DuplicateKeyException e)
        {
            System.out.println("Primary key"+ e.toString());
        }
        return this.sqlSession.selectList("fetchCustomers");
    }



    @Override
    public boolean validateCustomer(Customer c)
    {
        if(c.getCustomer_name()!=null && c.getLocation_id()>1000)
        return true;
        else
           return false;
    }

    @Override
    public Customer addandReturnCustomer(Customer c) {
        try {
            this.sqlSession.insert("insert", c);
            System.out.println("Primary key"+ c.getCustomer_id());
        }catch(org.springframework.dao.DuplicateKeyException e)
        {
            System.out.println("Primary key is repeated "+ e.getCause());
        }

        return c;
    }
}
