package com.mybatis.example.demomybatis.service.dao;

import com.mybatis.example.demomybatis.service.daoInterfaces.IFullCustomer;
import com.mybatis.example.demomybatis.service.model.FullCustomer;
import com.mybatis.example.demomybatis.service.model.Location;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.HashMap;
import java.util.List;

@Component
public class FullCustomerDAO implements IFullCustomer {

    private SqlSession sqlSession;
    @Autowired
    PlatformTransactionManager transactionManager;

    public FullCustomerDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<FullCustomer> getAllCustomerDetails() {
        return this.sqlSession.selectList("getCustomers");
    }

    @Override
    public FullCustomer insertFullCustomer(FullCustomer customer) {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Location location=this.sqlSession.selectOne("checkAndFetchLocation", customer);
            if(location!=null)
                System.out.println("Location " + location.getLocation_id());
            else
            {
                System.out.println("Location Not Available");
                location = new Location(customer.getStreet_address(),customer.getPostal_code(),customer.getCity(),customer.getState_province(),customer.getCountry_id());
                this.sqlSession.insert("insertLocation", location);
                System.out.println("Location Added id = "+ location.getLocation_id());
            }
            customer.setLocation_id(location.getLocation_id());
            this.sqlSession.insert("insert",customer);
        }
        catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);

        return customer;
    }

//    public void doFooBar() throws MyDaoException {
//        // Starts a new SqlSession
//
//        this.sessionManager.startManagedSession(ExecutorType.BATCH,
//                TransactionIsolationLevel.READ_UNCOMMITTED);
//        try {
//            // Retrieve the FooMapper and execute the doFoo() method.
//            FooMapper fooMapper = this.sessionManager.getMapper(FooMapper.class);
//            fooMapper.doFoo();
//
//            // Retrieve the BarMapper and execute the doBar() method.
//            BarMapper barMapper = this.sessionManager.getMapper(BarMapper.class);
//            barMapper.doBar();
//
//            // If everything gone fine, commit the open session.
//            this.sessionManager.commit();
//        } catch (Throwable t) {
//            // If something gone wrong, rollback the open session.
//            this.sessionManager.rollback();
//            // Optionally, throw a proper DAO layer Exception
//            throw new MyDaoException("Something went wrong", t);
//        } finally {
//            // Close the session.
//            this.sessionManager.close();
//        }
//    }
}

//    @Override
//    public FullCustomer insertFullCustomer(FullCustomer customer) {
//
//
//
//        Location location=this.sqlSession.selectOne("checkAndFetchLocation", customer);
//        if(location!=null)
//            System.out.println("Location " + location.getLocation_id());
//        else
//        {
//            System.out.println("Location Not Available");
//            location = new Location(customer.getStreet_address(),customer.getPostal_code(),customer.getCity(),customer.getState_province(),customer.getCountry_id());
//            this.sqlSession.insert("insertLocation", location);
//            System.out.println("Location Added id = "+ location.getLocation_id());
//        }
//        customer.setLocation_id(location.getLocation_id());
//        this.sqlSession.insert("insert",customer);
//
//        return customer;
//    }