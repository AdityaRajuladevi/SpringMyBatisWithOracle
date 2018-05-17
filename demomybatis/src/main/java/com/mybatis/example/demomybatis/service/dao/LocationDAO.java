package com.mybatis.example.demomybatis.service.dao;

import com.mybatis.example.demomybatis.service.daoInterfaces.ILocationDAO;
import com.mybatis.example.demomybatis.service.model.Location;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationDAO implements ILocationDAO {

    private SqlSession sqlSession;

    public LocationDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Location> getAllLocations() {
        return this.sqlSession.selectList("fetchLocations");
    }
}
