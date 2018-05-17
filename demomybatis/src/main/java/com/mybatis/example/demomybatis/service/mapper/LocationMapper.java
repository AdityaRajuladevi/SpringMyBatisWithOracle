package com.mybatis.example.demomybatis.service.mapper;

import com.mybatis.example.demomybatis.service.model.Location;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface LocationMapper {

        @Results({
                @Result(property = "location_id", column = "LOCATION_ID"),
                @Result(property = "street_address", column = "STREET_ADDRESS"),
                @Result(property = "postal_code", column = "POSTAL_CODE"),
                @Result(property = "city", column = "CITY"),
                @Result(property = "state_province", column = "STATE_PROVINCE"),
                @Result(property = "country_id", column = "COUNTRY_ID")

        })
        @Select("select LOCATION.LOCATION_ID, LOCATION.STREET_ADDRESS, LOCATION.POSTAL_CODE , LOCATION.CITY, LOCATION.STATE_PROVINCE, LOCATION.COUNTRY_ID " +
                "from LOCATION")
        List<Location> fetchLocations();


        @Select("select location_id from Location \n" +
                "where LOCATION.STREET_ADDRESS= #{street_address} and LOCATION.POSTAL_CODE = #{postal_code} and LOCATION.CITY = #{city}")
        Location checkAndFetchLocation();
        // @Param("street_address") String street_address, @Param("postal_code") String postal_code, @Param("city") String city

        @Insert("INSERT into Location(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) values " +
                "(#{location_id},#{street_address},#{postal_code},#{city},#{state_province},#{country_id})")
        @SelectKey(statement = "SELECT LOCATION_SEQUENCE.NEXTVAL from dual", keyProperty = "location_id",
                before = true, resultType = Integer.class)
        int insertLocation(Location location);
}