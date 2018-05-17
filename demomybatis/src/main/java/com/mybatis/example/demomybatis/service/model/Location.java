package com.mybatis.example.demomybatis.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    @JsonProperty("street_address")
    private String street_address;

    @JsonProperty("location_id")
    private int location_id;

    @JsonProperty("postal_code")
    private String postal_code;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_province")
    private String state_province;

    @JsonProperty("country_id")
    private String country_id;

    public Location()
    {

    }

    public Location(String street_address, String postal_code, String city, String state_province, String country_id)
    {
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.state_province = state_province;
        this.country_id = country_id;

    }
}
