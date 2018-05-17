package com.mybatis.example.demomybatis.service.daoInterfaces;

import com.mybatis.example.demomybatis.service.model.Location;

import java.util.List;

public interface ILocationDAO {
    List<Location> getAllLocations();
}
