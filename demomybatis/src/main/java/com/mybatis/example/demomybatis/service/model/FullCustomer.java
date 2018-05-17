package com.mybatis.example.demomybatis.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FullCustomer {

    @JsonProperty("customer_name")
    private String customer_name;

    @JsonProperty("customer_ID")
    private int customer_id;

    @JsonProperty("location_id")
    private int location_id;

    @JsonProperty("street_address")
    private String street_address;

    @JsonProperty("postal_code")
    private String postal_code;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_province")
    private String state_province;

    @JsonProperty("country_id")
    private String country_id;
}
