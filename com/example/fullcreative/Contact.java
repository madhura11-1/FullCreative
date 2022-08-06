package com.example.fullcreative;

import java.util.ArrayList;

public class Contact {

    String name;
    String phone_number;
    String additional_information;


    public void setContactDetails(String name, String phone_number, String additional_information){

        this.name = name;
        this.phone_number = phone_number;
        this.additional_information = additional_information;
    }

    public void getContactDetails(){

        System.out.println("Name : " + name);
        System.out.println("Phone Number : " + phone_number);
        System.out.println("Additional Information : " + additional_information);

    }

    public void editName(String new_name){
        name = new_name;
    }

    public void editNumber(String new_number){
        phone_number = new_number;
    }

    public  void  editAdditionalInformation(String new_info){
        additional_information = new_info;
    }

}
