package com.example.fullcreative;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Contact extends People {

    static int contact_id;
    String relationv;
    HashMap<String, String> phoneNumber;
    HashMap<String,String> email;
    HashMap<Date,String> significantDate;
    HashMap<String,String> relatedPersonNo;
    String saveTo;
    boolean favourite;
    boolean spam;
    boolean blocked;
    ArrayList<Integer> linked_id;
    public static ArrayList<Contact> contacts = new ArrayList<>();

    public Contact(){

        //initialization
        contact_id = contact_id + 1;
        phoneNumber = new HashMap<>();
        email = new HashMap<>();
        significantDate = new HashMap<>();
        relatedPersonNo = new HashMap<>();
        linked_id = new ArrayList<>();
        favourite = false;
        spam = false;
        blocked = false;

    }


    public int getContact_id(){
        return contact_id;
    }

    public static ArrayList<Contact> getContacts(){
        return contacts;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(String photo) {
         this.photo = photo;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber,int type){

        if(this.phoneNumber.isEmpty()) {
            this.phoneNumber.put(phoneNumber, Enums.phoneNumber.getValue(type));
        }else{
            this.phoneNumber.clear();
            this.phoneNumber.put(phoneNumber, Enums.phoneNumber.getValue(type));
        }

    }

    public HashMap<String,String> getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(String email, int type){

        if(this.email.isEmpty()) {
            this.email.put(email, Enums.email.getValue(type));
        }else{
            this.email.clear();
            this.email.put(email, Enums.email.getValue(type));
        }
    }

    public HashMap<String,String> getEmail(){
        return this.email;
    }

    public void setSignificantDate(Date d, int type){

        if(this.significantDate.isEmpty()) {
            this.significantDate.put(d, Enums.date.getValue(type));
        }else{
            this.significantDate.clear();
            this.significantDate.put(d, Enums.date.getValue(type));
        }
    }

    public HashMap<Date,String> getSignificantDate(){
        return this.significantDate;
    }

    public void setRelatedPersonNo(String personNo, int type){

        if(this.relatedPersonNo.isEmpty()){
        this.relatedPersonNo.put(Enums.relation.getValue(type),personNo);}
        else{
            this.relatedPersonNo.clear();
            this.relatedPersonNo.put(Enums.relation.getValue(type),personNo);
    }
    }

    public HashMap<String,String> getRelatedPersonNo(){
        return this.relatedPersonNo;
    }

    public void setSaveTo(int type){
        this.saveTo = Enums.saveTo.getValue(type);
    }

    public String getsaveto(){
        return this.saveTo;
    }

    public void setRelationv(int n){
        relationv = Enums.relation.getValue(n);
    }

    public String getRelationv(){
        return relationv;
    }

    public void markFavourite(){
        this.favourite = true;
    }

    public void blockContact(){

        this.blocked = true;

    }

    public void setSpam(){

        this.spam = true;
    }

    public void removeFavourite(){
        this.favourite = false;
    }

    public void unblockContact(){

        this.blocked = false;

    }

    public void removeSpam(){

        this.spam = false;
    }



    public void setLinked_id(int id){
        linked_id.add(id);
    }

    public ArrayList<Integer> getLinked_ids(){
        return linked_id;
    }


}

