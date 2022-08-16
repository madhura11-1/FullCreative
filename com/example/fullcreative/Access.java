package com.example.fullcreative;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
        System.out.println(contacts.size());
        int i =0;
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

     public void update(Scanner sc){


            System.out.println("Enter the id to be updated");
            int id = sc.nextInt();
            ArrayList<Contact> c = Contact.getContacts();
            if(id >= 1 && id <= c.size()) {
                Contact obj = c.get(id-1);
                System.out.println("Enter the corresponding integer to update");
                System.out.println("1. First Name \n 2. Middle Name \n 3. Last Name");
                int choice = sc.nextInt();
                switch (choice) {

                    case 1: System.out.println("Enter the new first name to be updated");
                            obj.setFirstName(sc.next());
                            break;
                    case 2: System.out.println("Enter the new middle name to be updated");
                            obj.setMiddleName(sc.next());
                            break;
                    case 3: System.out.println("Enter the new last name to be updated");
                            obj.setLastName(sc.next());
                            break;
                    case 4: System.out.println("Enter the new number and also the type again");
                            obj.setPhoneNumber(sc.next(),sc.nextInt());
                            break;
                    case 5: System.out.println("Enter the new email and the type again");
                            obj.setEmail(sc.next(),sc.nextInt());
                            break;
                    case 6: System.out.println("Enter the new relation with ther person");
                            obj.setRelationv(sc.nextInt());
                             break;
                }
            }
            else{
                System.out.println("This id does not exists");
            }

        }

        public void delete(Scanner sc) {

            System.out.println("Enter the id to be deleted");
            int id = sc.nextInt();
            ArrayList<Contact> c = Contact.getContacts();
            if (id >= 1 && id <= c.size()) {
                Contact obj = c.get(id - 1);
                    c.remove(obj);
                    Contact.contact_id = Contact.contact_id-1;
            }
            else{
                System.out.println("This id does not exists");
            }
        }

    public static void main(String[] args) throws ParseException {

            Scanner sc = new Scanner(System.in);
            System.out.println("Select the photo");
            String p = sc.next();
            System.out.println("Enter the first name");
            String namef = sc.next();
            System.out.println("Enter the middle name");
            String namem = sc.next();
            System.out.println("Enter the last name");
            String namel = sc.next();
            System.out.println("Enter the phone number");
            String phoneNumber = sc.next();
        System.out.println("Enter 0 if no label \n Enter 1 if work number \n Enter 2 if home number \n Enter 3 if main number \n Enter 4 if custom");
        int pnt = sc.nextInt();
        System.out.println("Select relation of  person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n 4 if brother \n 5 if spouse \n 6 if child \n 7 if friend \n 8 if colleague \n 9 if custom");
            int v = sc.nextInt();
            System.out.println("Enter the email");
            String email = sc.next();
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
            System.out.println("Enter 0 if save to phone \n Enter 1 if save to drive");
            int st = sc.nextInt();


            Access access = new Access();
            access.createContact(p, namef, namem, namel, phoneNumber, pnt, date1, dt, email, et, pnr, person, st,v);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("23/04/2022");
            access.createContact("photo2", "Sarita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
            access.createContact("photo2", "Kavita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
             access.createContact("photo2", "Lalita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);


            access.getContacts();


            access.update(sc);

            access.delete(sc);

            access.getContacts();


    }

}
