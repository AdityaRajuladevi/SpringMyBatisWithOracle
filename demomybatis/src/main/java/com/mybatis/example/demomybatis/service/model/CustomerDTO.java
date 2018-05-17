

package com.mybatis.example.demomybatis.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {


    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    @JsonProperty("Name")
    private String FIRSTNAME;
    private String secondName;



    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


}














//package lankydan.tutorial.springboot.dto;
//
//public class CustomerDTO {
//
//    public CustomerDTO() {}
//
//    CustomerDTO(String firstName, String secondName)
//    {
//        this.firstName=firstName;
//        this.secondName=secondName;
//    }
//
//    private String firstName;
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    private String secondName;
//}
