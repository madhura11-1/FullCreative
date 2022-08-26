package com.example.fullcreative;
import java.util.Date;

public class Contact extends People {

    static int contact_id;
    String address,company;
    String notes,website;
    String relationv;
    CustomHashMap<String, String> phoneNumber;
    CustomHashMap<String,String> email;
    CustomHashMap<Date,String> significantDate;
    CustomHashMap<String,String> relatedPersonNo;
    String saveTo;
    boolean favourite;
    boolean spam;
    boolean blocked;
    CustomArrayList<Integer> linked_id;
    public static CustomArrayList<Contact> contacts = new CustomArrayList<>();

    public Contact(){

        //initialization
        contact_id = contact_id + 1;
        phoneNumber = new CustomHashMap<>();
        email = new CustomHashMap<>();
        significantDate = new CustomHashMap<>();
        relatedPersonNo = new CustomHashMap<>();
        linked_id = new CustomArrayList<>();
        favourite = false;
        spam = false;
        blocked = false;

    }


    public int getContact_id(){
        return contact_id;
    }

    public static CustomArrayList<Contact> getContacts(){
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

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public String getCompany(){
        return this.company;
    }

    public void setPhoneNumber(CustomHashMap<String,String> phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public CustomHashMap<String,String> getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(CustomHashMap<String,String> email){
            this.email = email;
    }

    public CustomHashMap<String,String> getEmail(){
        return this.email;
    }

    public void setSignificantDate(CustomHashMap<Date,String> date){
        this.significantDate = date;
    }

    public CustomHashMap<Date,String> getSignificantDate(){
        return this.significantDate;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public String getWebsite(){
        return this.website;
    }

    public void setRelatedPersonNo(String personNo, int type){

        if(this.relatedPersonNo.isEmpty()){
        this.relatedPersonNo.put(Enums.relation.getValue(type),personNo);}
        else{
            this.relatedPersonNo.clear();
            this.relatedPersonNo.put(Enums.relation.getValue(type),personNo);
    }
    }

    public CustomHashMap<String,String> getRelatedPersonNo(){
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

    public void setNotes(String notes){
        this.notes = notes;
    }

    public String getNotes(){
        return this.notes;
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

    public CustomArrayList<Integer> getLinked_ids(){
        return linked_id;
    }


}

