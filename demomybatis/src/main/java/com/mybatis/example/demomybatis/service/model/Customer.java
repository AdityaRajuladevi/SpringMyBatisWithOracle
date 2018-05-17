package com.mybatis.example.demomybatis.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Customer {

    @JsonProperty("customer_name")
    private String customer_name;
    @JsonProperty("customer_ID")
    private int customer_id;
    @JsonProperty("location_id")
    private int location_id;

}