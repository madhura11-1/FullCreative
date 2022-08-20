package com.example.fullcreative;

import android.os.health.SystemHealthManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Access {


    public void createContact(String p, String f, String m, String l, String pn, int pt, Date d, int dt, String e, int et, String r, int rt, int sto,int v){

        Contact c = new Contact();
        c.setPhoto(p);
        c.setFirstName(f);
        c.setMiddleName(m);
        c.setLastName(l);
        c.setPhoneNumber(pn,pt);
        c.setSignificantDate(d, dt);
        c.setEmail(e,et);
        c.setRelatedPersonNo(r,rt);
        c.setSaveTo(sto);
        c.setRelationv(v);
        Contact.contacts.add(c);
    }

    public void getContacts() {

        ArrayList<Contact> contacts = Contact.getContacts();

        if(contacts.size() <= 0){
            System.out.println("There are no contacts present. Please add contacts \n");
        }
        else {
            System.out.println("Total number of contacts " + contacts.size());
            int i = 0;
            for (Contact c : contacts) {
                i = i + 1;
                System.out.println(i);
                System.out.println(c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName());
                System.out.println(c.getPhoneNumber());
                System.out.println(c.getEmail());
                System.out.println(c.getRelationv());
                System.out.println(c.getSignificantDate());
                System.out.println(c.getRelatedPersonNo());
                System.out.println(c.getsaveto());
                System.out.println(c.getLinked_ids());
                System.out.println("\n");

            }
        }
    }

     public void update(Scanner sc, String number){
            ArrayList<Contact> c = Contact.getContacts();
            if(checkNumber(number)) {
                for(Contact con : c) {
                    if (con.getPhoneNumber().containsKey(number)) {
                        System.out.println("Enter the corresponding integer to update");
                        System.out.println("1. First Name \n 2. Middle Name \n 3. Last Name \n 4. Phone number \n 5. Email \n 6. Change Relation with Person");
                        int choice = sc.nextInt();
                        switch (choice) {

                            case 1:
                                System.out.println("Enter the new first name to be updated");
                                con.setFirstName(sc.next());
                                break;
                            case 2:
                                System.out.println("Enter the new middle name to be updated");
                                con.setMiddleName(sc.next());
                                break;
                            case 3:
                                System.out.println("Enter the new last name to be updated");
                                con.setLastName(sc.next());
                                break;
                            case 4:
                                System.out.println("Enter the new number and also the type of the number");
                                con.setPhoneNumber(sc.next(), sc.nextInt());
                                break;
                            case 5:
                                System.out.println("Enter the new email and the type of the email");
                                con.setEmail(sc.next(), sc.nextInt());
                                break;
                            case 6:
                                System.out.println("Enter the new relation with the person");
                                con.setRelationv(sc.nextInt());
                                break;
                        }
                        break;
                    }else{
                        System.out.println("This number does not exists");
                    }
                }
            }
            else{
                System.out.println("Please enter a valid number");
            }

        }

        public void delete(Scanner sc, String number) {
            ArrayList<Contact> c = Contact.getContacts();
            if (checkNumber(number)) {
                for (Contact con : c) {
                    if (con.getPhoneNumber().containsKey(number)) {
                        c.remove(con);
                        Contact.contact_id = Contact.contact_id - 1;
                        break;
                    }
                    else{
                        System.out.println("This number does not exixts");
                    }
                }
            }
            else{
                System.out.println("Please enter a valid number");

            }
        }

        public boolean checkString(String s){

        char[] ch = s.toCharArray();

        for(char c : ch){
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;

        }

        public boolean checkNumber(String s){
             if(s.length() == 10){
                 char[] ch = s.toCharArray();
                 for(char c : ch) {
                     if(!Character.isDigit(c)){
                         return false;
                     }
                 }
                 return true;
             }else{
                 return false;
             }
        }

        public boolean checkMail(String s) {
            String regex = "[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z]{2,4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }

        public void searchNumber(Scanner sc) {

            System.out.println("Enter the number to be searched");
            String number = sc.next();
            if (this.checkNumber(number)) {

                ArrayList<Contact> contacts = Contact.getContacts();
                for(int i=0;i<contacts.size();i++){
                    Contact c = contacts.get(i);
                    if(c.getPhoneNumber().containsKey(number)){
                        System.out.println(c);
                        System.out.println(i+1);
                        System.out.println(c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName());
                        System.out.println(c.getPhoneNumber());
                        System.out.println(c.getEmail());
                        System.out.println(c.getRelationv());
                        System.out.println(c.getSignificantDate());
                        System.out.println(c.getRelatedPersonNo());
                        System.out.println(c.getsaveto());
                        System.out.println(c.getLinked_ids());
                        System.out.println("\n");
                    }
                    else{
                        System.out.println("No such number found");
                    }
                }

                }
        else{
        System.out.println("Please enter a correct number");}
    }

    public void searchName(Scanner sc){

        System.out.println("Enter the name to be searched");
        String name = sc.next();
            ArrayList<Contact> contacts = Contact.getContacts();
            int i;
            for(i=0;i<contacts.size();i++) {
                Contact c = contacts.get(i);
                String fullName = c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName();
                if (fullName.contains(name)) {
                    System.out.println(c);
                    System.out.println(i + 1);
                    System.out.println(c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName());
                    System.out.println(c.getPhoneNumber());
                    System.out.println(c.getEmail());
                    System.out.println(c.getRelationv());
                    System.out.println(c.getSignificantDate());
                    System.out.println(c.getRelatedPersonNo());
                    System.out.println(c.getsaveto());
                    System.out.println(c.getLinked_ids());
                    System.out.println("\n");
                    break;
                }
            }
            if(i == contacts.size()){
                System.out.println("NO such name exists");
            }

        }

        public void search(){

        System.out.println("Enter 1 to search by number");
        System.out.println("Enter 2 to search by name");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){

            case 1: searchNumber(sc);
                    break;
            case 2: searchName(sc);
                    break;

        }

        }

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        boolean x = true;
        do{
            System.out.println("Enter 1 to create new contact");
            System.out.println("Enter 2 to view all contacts");
            System.out.println("Enter 3 to update existing contact");
            System.out.println("Enter 4 to delete contact");
            System.out.println("Enter 5 to search contact using name or number");
            System.out.println("Enter 6 to stop");
            int a = sc.nextInt();
            Access access = new Access();;

            switch (a){
                case 1 :    System.out.println("Select the photo");
                            String p = sc.next();
                            System.out.println("Enter the first name");
                            String namef = sc.next();
                            System.out.println("Enter the middle name");
                            String namem = sc.next();
                            System.out.println("Enter the last name");
                            String namel = sc.next();
                            System.out.println("Enter the phone number");
                            String phoneNumber = sc.next();
                            if(!access.checkNumber(phoneNumber)){
                             System.out.println("Please enter a valid phone number which is a 10 digit number");
                            }
                            else {
                                System.out.println("Enter 0 if no label \n Enter 1 if work number \n Enter 2 if home number \n Enter 3 if main number \n Enter 4 if custom");
                                int pnt = sc.nextInt();
                                System.out.println("Select relation of  person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n Enter 4 if brother \n Enter 5 if spouse \n Enter 6 if child \n Enter 7 if friend \n Enter 8 if colleague \n Enter 9 if custom");
                                int v = sc.nextInt();
                                System.out.println("Enter the email");
                                String email = sc.next();
                                if (!access.checkMail(email)) {
                                    System.out.println("Please enter a valid email");
                                } else {
                                    System.out.println("Enter 0 if no label \n Enter 1 if work email \n  Enter 2 if custom");
                                    int et = sc.nextInt();
                                    System.out.println("Enter any significant date in format dd/mm/yyyy");
                                    String date = sc.next();
                                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                                    System.out.println("Enter 0 if no label \n Enter 1 if birth date \n  Enter 2 if anniversary date \n Enter 3 if custom");
                                    int dt = sc.nextInt();
                                    System.out.println("Select related person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n 4 if brother \n 5 if spouse \n 6 if child \n 7 if friend \n 8 if colleague \n 9 if custom");
                                    int person = sc.nextInt();
                                    System.out.println("Enter the phone number of the related person");
                                    String pnr = sc.next();
                                    if (!access.checkNumber(pnr)) {
                                        System.out.println("Please enter a valid phone number which is a 10 digit number \n");
                                    } else {
                                        System.out.println("Enter 0 if save to phone \n Enter 1 if save to drive");
                                        int st = sc.nextInt();
                                        access.createContact(p, namef, namem, namel, phoneNumber, pnt, date1, dt, email, et, pnr, person, st, v);
                                    }
                                }
                            }
                            break;
                case 2: access.getContacts();
                        break;
                case 3: System.out.println("Enter the phoneNumber of the contact to be updated");
                        String id = sc.next();
                        access.update(sc,id);
                        break;
                case 4: System.out.println("Enter the phoneNumber of the contact to be updated");
                        String id1 = sc.next();
                        access.delete(sc, id1);
                        break;
                case 5: access.search();
                        break;
                case 6: x = false;
            }

        }while(x);


//            System.out.println("Select the photo");
//            String p = sc.next();
//            System.out.println("Enter the first name");
//            String namef = sc.next();
//            System.out.println("Enter the middle name");
//            String namem = sc.next();
//            System.out.println("Enter the last name");
//            String namel = sc.next();
//            System.out.println("Enter the phone number");
//            String phoneNumber = sc.next();
//            System.out.println("Enter 0 if no label \n Enter 1 if work number \n Enter 2 if home number \n Enter 3 if main number \n Enter 4 if custom");
//            int pnt = sc.nextInt();
//            System.out.println("Select relation of  person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n Enter 4 if brother \n Enter 5 if spouse \n Enter 6 if child \n Enter 7 if friend \n Enter 8 if colleague \n Enter 9 if custom");
//            int v = sc.nextInt();
//            System.out.println("Enter the email");
//            String email = sc.next();
//            System.out.println("Enter 0 if no label \n Enter 1 if work email \n  Enter 2 if custom");
//            int et = sc.nextInt();
//            System.out.println("Enter any significant date in format dd/mm/yyyy");
//            String date = sc.next();
//            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//            System.out.println("Enter 0 if no label \n Enter 1 if birth date \n  Enter 2 if anniversary date \n Enter 3 if custom");
//            int dt = sc.nextInt();
//            System.out.println("Select related person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n 4 if brother \n 5 if spouse \n 6 if child \n 7 if friend \n 8 if colleague \n 9 if custom");
//            int person = sc.nextInt();
//            System.out.println("Enter the phone number of the related person");
//            String pnr = sc.next();
//            System.out.println("Enter 0 if save to phone \n Enter 1 if save to drive");
//            int st = sc.nextInt();



//            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("23/04/2022");
//            access.createContact("photo2", "Sarita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
//            access.createContact("photo2", "Kavita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
//             access.createContact("photo2", "Lalita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);


//            access.getContacts();

    }

}
