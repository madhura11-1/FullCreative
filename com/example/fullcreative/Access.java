package com.example.fullcreative;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Access {



    public void createContact(String p, String f, String m, String l,String address,String company, CustomHashMap<String,String> pn, CustomHashMap<Date,String> d, CustomHashMap<String,String> e,String social, String r, int rt,String notes, int sto,int v) {

        Contact c = new Contact();
        c.setPhoto(p);
        c.setFirstName(f);
        c.setMiddleName(m);
        c.setLastName(l);
        c.setAddress(address);
        c.setCompany(company);
        c.setPhoneNumber(pn);
        c.setSignificantDate(d);
        c.setEmail(e);
        c.setWebsite(social);
        c.setRelatedPersonNo(r,rt);
        c.setNotes(notes);
        c.setSaveTo(sto);
        c.setRelationv(v);
        Contact.contacts.add(c);

    }

    public void getContacts() {

        CustomArrayList<Contact> contacts = Contact.getContacts();

        if(contacts.size() <= 0){
            System.out.println("There are no contacts present. Please add contacts \n");
        }
        else {
            System.out.println("Total number of contacts " + contacts.size());
            int i = 0;
            for (Contact c : contacts) {
                i = i + 1;
                System.out.println(i);
                String name = c.getFirstName() + c.getMiddleName()  + c.getLastName();
                if(name.isEmpty()){
                    System.out.println("Name: No Value \n");
                }else {
                    System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName() + "\n");
                }
                if(c.getAddress().isEmpty()){
                    System.out.println("Address: No Value \n");
                }else {
                    System.out.println("Address: " + c.getAddress() + "\n");
                }
                if(c.getCompany().isEmpty()){
                    System.out.println("Company: No Value \n");
                }else{
                System.out.println("Company: " + c.getCompany() + "\n");}
                String phone = c.getPhoneNumber().get();
                System.out.println("Phone Number: " + phone);
                String email = c.getEmail().get();
                System.out.println("Email: " + email);
                System.out.println("Relationship of the person with you: " + c.getRelationv() + "\n");
                String date = c.getSignificantDate().get();
                System.out.println("Significant Date:" + date);
                if(c.getWebsite().isEmpty()){
                    System.out.println("Website/Social Media: No Value \n");
                }else {
                    System.out.println("Website/Social Media: " + c.getWebsite() + "\n");
                }
                String per = c.getRelatedPersonNo().get();
                System.out.println("Person related to " + c.getFirstName() + " : " + per);
                if(c.getNotes().isEmpty()){
                    System.out.println("Notes: No Value \n");
                }else{
                System.out.println("Notes: " + c.getNotes() + "\n");
                }
                System.out.println("Saved to: " + c.getsaveto());
                System.out.println("\n");

            }
        }
    }

     public void update(Scanner sc, String number) {
         CustomArrayList<Contact> c = Contact.getContacts();
         if (c.size() <= 0) {
            System.out.println("Please create a contact first \n");
         } else {
             if (checkNumber(number)) {
                 for (Contact con : c) {
                     if (con.getPhoneNumber().containsKey(number)) {
                         System.out.println("Enter the corresponding integer to update");
                         System.out.println("1. First Name \n 2. Middle Name \n 3. Last Name \n 4. Phone number \n 5. Email \n 6. Address \n 7. Change Relation with Person \n 8. Website");
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
                                 System.out.println("Enter the number to be updated");
                                 String oldNumber = sc.next();
                                 if(con.getPhoneNumber().containsKey(oldNumber)){
                                     System.out.println("Enter the new number and also the type of the number");
                                     con.getPhoneNumber().remove(oldNumber);
                                     con.getPhoneNumber().put(sc.next(),Enums.phoneNumber.getValue(sc.nextInt()));
                             }else{
                                     System.out.println("The number to be updated does not exists");
                                 }
                                 break;
                             case 5:
                                 System.out.println("Enter the email to be updated");
                                 String oldEmail = sc.next();
                                 if(con.getEmail().containsKey(oldEmail)){
                                     System.out.println("Enter the new email and the type of the email");
                                     con.getEmail().remove(oldEmail);
                                     con.getEmail().put(sc.next(), Enums.email.getValue(sc.nextInt()));
                                 }else{
                                     System.out.println("The email to be updated does not exists");
                                 }
                                 break;
                             case 6:
                                 System.out.println("Enter the new address");
                                 con.setAddress(sc.next());
                                 break;
                             case 7:
                                 System.out.println("Enter the new relation with the person");
                                 con.setRelationv(sc.nextInt());
                                 break;
                             case 8:
                                 System.out.println("Enter the new website to update");
                                 con.setWebsite(sc.next());
                                 break;
                             default:
                                 System.out.println("Please enter a proper choice");
                         }
                         break;
                     } else {
                         System.out.println("This number does not exists \n");
                     }
                 }
             } else {
                 System.out.println("Please enter a valid number \n");
             }

         }
     }

        public void delete(Scanner sc, String number) {
            CustomArrayList<Contact> c = Contact.getContacts();
            if (c.size() <= 0) {
                System.out.println("Please create a contact first \n");
            } else {
                if (checkNumber(number)) {
                    for (Contact con : c) {
                        if (con.getPhoneNumber().containsKey(number)) {
                            c.remove(con);
                            Contact.contact_id = Contact.contact_id - 1;
                            break;
                        } else {
                            System.out.println("This number does not exists \n");
                        }
                    }
                } else {
                    System.out.println("Please enter a valid number \n");

                }
            }
        }
            public boolean checkString (String s){

                char[] ch = s.toCharArray();

                for (char c : ch) {
                    if (!Character.isLetter(c)) {
                        return false;
                    }
                }
                return true;

            }

        public boolean checkNumber(String s){

                 if (s.matches("^(91)?[6-9][0-9]{9}$"))  //919898989898
                     return true;
                 else if(s.matches("^(0)?[6-9][0-9]{9}$"))
                     return true;
                 else if (s.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) //876.456.4567, 876-456-4567
                     return true;
                 else if (s.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}")) //3456.345.345, 3456.345-345
                     return true;
                 else if (s.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) //345-344-3456 x4444
                     return true;
                 else if(s.matches("\\d{1}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
                     return true;
                 else if(s.matches("\\d{7,15}"))
                     return true;
                 else
                 return false;
        }

        public boolean checkDate(String date){

        String regex = "^([0-9])([0-9])?(\\/)([0-9])([0-9])?(\\/)(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
        }

        public boolean checkMail(String s) {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z]{2,4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }

        public void searchNumber(Scanner sc) {

            System.out.println("Enter the number to be searched");
            String number = sc.next();
            if (this.checkNumber(number)) {

                CustomArrayList<Contact> contacts = Contact.getContacts();
                if (contacts.size() <= 0) {
                    System.out.println("Please create a contact first \n");
                }else {
                    for (int i = 0; i < contacts.size(); i++) {
                        Contact c = contacts.get(i);
                        if (c.getPhoneNumber().containsKey(number)) {
                            //System.out.println(c);
                            System.out.println(i + 1);
                            System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName() + "\n");
                            System.out.println("Phone Number: " + c.getPhoneNumber().get());
                            System.out.println("Email: " + c.getEmail().get());
                            System.out.println("Relationship of the person with you: " + c.getRelationv() + "\n");
                            System.out.println("Significant Date:" + c.getSignificantDate().get());
                            System.out.println("Person related to " + c.getFirstName() + " : " + c.getRelatedPersonNo().get());
                            System.out.println("Saved to: " + c.getsaveto());
                            System.out.println("\n");
                        } else {
                            System.out.println("No such number found \n");
                        }
                    }
                }

                }
        else{
        System.out.println("Please enter a correct number \n");}
    }

    public void searchName(Scanner sc) {

        System.out.println("Enter the name to be searched");
        String name = sc.next();
        CustomArrayList<Contact> contacts = Contact.getContacts();
        if (contacts.size() <= 0) {
            System.out.println("Please create a contact first \n");
        } else {
            int i,flag = 0;
            for (i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                String fullName = c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName();
                fullName = fullName.toLowerCase();
                name = name.toLowerCase();
                if (fullName.contains(name)) {
                    //System.out.println(c);
                    System.out.println(i + 1);
                    System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName() + "\n");
                    System.out.println("Phone Number: " + c.getPhoneNumber().get());
                    System.out.println("Email: " + c.getEmail().get());
                    System.out.println("Relationship of the person with you: " + c.getRelationv() + "\n");
                    System.out.println("Significant Date:" + c.getSignificantDate().get());
                    System.out.println("Person related to " + c.getFirstName() + " : " + c.getRelatedPersonNo().get());
                    System.out.println("Saved to: " + c.getsaveto());
                    System.out.println("\n");
                    flag = 1;
                }
            }
            if (i == contacts.size() && flag != 1) {
                System.out.println("NO such name exists \n");
            }

        }
    }

    public void searchMail(Scanner sc){

        System.out.println("Enter the email to be searched");
        String name = sc.next();
        if(this.checkMail(name)) {
            CustomArrayList<Contact> contacts = Contact.getContacts();
            if (contacts.size() <= 0) {
                System.out.println("Please create a contact first \n");
            } else {
                int i,flag = 0;
                for (i = 0; i < contacts.size(); i++) {
                    Contact c = contacts.get(i);
                    if (c.getEmail().containsKey(name)) {
                        //System.out.println(c);
                        System.out.println(i + 1);
                        System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName() + "\n");
                        System.out.println("Phone Number: " + c.getPhoneNumber().get());
                        System.out.println("Email: " + c.getEmail().get());
                        System.out.println("Relationship of the person with you: " + c.getRelationv() + "\n");
                        System.out.println("Significant Date:" + c.getSignificantDate().get());
                        System.out.println("Person related to " + c.getFirstName() + " : " + c.getRelatedPersonNo().get());
                        System.out.println("Saved to: " + c.getsaveto());
                        System.out.println("\n");
                        flag = 1;
                    }
                }
                if (i == contacts.size() && flag != 1) {
                    System.out.println("NO such email exists \n");
                }

            }
        }else{
            System.out.println("Enter a valid email \n");
        }

    }

        public void search(){

        System.out.println("Enter 1 to search by number");
        System.out.println("Enter 2 to search by name");
        System.out.println("Enter 3 to search by email");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){

            case 1: searchNumber(sc);
                    break;
            case 2: searchName(sc);
                    break;
            case 3: searchMail(sc);
                    break;
            default: System.out.println("Please select a proper choice");

        }

        }

    public void importFile() throws IOException {

        String line = "";
        String splitBy = ",";

        //Bufferreader is synchronous whereas Scanner is not. An buffer size is 8KB as compared to 1 KB of Scanner.
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Admin\\AndroidStudioProjects\\FullCreative\\ExportCSV1.csv"));
        while ((line = br.readLine()) != null)
        {
            String[] contact = line.split(splitBy);
            System.out.println("[First Name=" + contact[0] + ", Last Name=" + contact[6] + ", Company=" + contact[2] + ", Contact=" + contact[1] + ", Email= " + contact[4] + ", Address= " + contact[5] +"]");
            CustomHashMap<String,String> pn = new CustomHashMap<>();
            pn.put(contact[1],Enums.phoneNumber.getValue(0));
            CustomHashMap<String,String> email = new CustomHashMap<>();
            email.put(contact[4],Enums.email.getValue(0));
            CustomHashMap<Date,String> date = new CustomHashMap<>();
            this.createContact("",contact[0],"",contact[6],contact[5],contact[2],pn,date,email,"","",0,"",0,0);
        }
    }

    public void exportFile() throws IOException {


            Workbook workbook = new XSSFWorkbook();
            File file = new File("contacts.xlsx");
            FileOutputStream fileWrite = new FileOutputStream(file);
            Sheet sheet = workbook.createSheet("Contacts");
            Row headerRow = sheet.createRow(0);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Sr. No");
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("First Name");
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Middle Name");
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Last Name");
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Address");
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Company");
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Phone Number and Type");
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Email");
            headerCell = headerRow.createCell(8);
            headerCell.setCellValue("Significant Date");
            headerCell = headerRow.createCell(9);
            headerCell.setCellValue("Website/Social Media");
            headerCell = headerRow.createCell(10);
            headerCell.setCellValue("Relation of the person with you");
            headerCell = headerRow.createCell(11);
            headerCell.setCellValue("Related person and the number");
            headerCell = headerRow.createCell(12);
            headerCell.setCellValue("Notes");
            headerCell = headerRow.createCell(13);
            headerCell.setCellValue("Save To");
            int Row = 1;
            CustomArrayList<Contact> contacts = Contact.getContacts();
            for(Contact c : contacts) {

                Row row = sheet.createRow(Row);
                Cell cell = row.createCell(0);
                cell.setCellValue(Row);
                cell = row.createCell(1);
                cell.setCellValue(c.getFirstName());
                cell = row.createCell(2);
                cell.setCellValue(c.getMiddleName());
                cell = row.createCell(3);
                cell.setCellValue(c.getLastName());
                cell = row.createCell(4);
                cell.setCellValue(c.getAddress());
                cell = row.createCell(5);
                cell.setCellValue(c.getCompany());
                cell = row.createCell(6);
                String phone = c.getPhoneNumber().get();
                cell.setCellValue(phone);
                cell = row.createCell(7);
                String email = c.getEmail().get();
                cell.setCellValue(email);
                cell = row.createCell(8);
                String date = c.getSignificantDate().get();
                cell.setCellValue(date);
                cell = row.createCell(9);
                cell.setCellValue(c.getWebsite());
                cell = row.createCell(10);
                cell.setCellValue(c.getRelationv());
                cell = row.createCell(11);
                String per = c.getRelatedPersonNo().get();
                cell.setCellValue(per);
                cell = row.createCell(12);
                cell.setCellValue(c.getNotes());
                cell = row.createCell(13);
                cell.setCellValue(c.getsaveto());
                Row++;
            }

            workbook.write(fileWrite);
            fileWrite.close();
            workbook.close();

//            System.out.println("In the else block");
//            File file = new File("C:\\Users\\Admin\\AndroidStudioProjects\\FullCreative\\contacts.xlsx");
//            System.out.println(file);
//            FileInputStream fileRead = new FileInputStream(file);
//            if(file.exists()){
//                System.out.println("file exists");
//                Workbook workbook = new XSSFWorkbook(fileRead);
//                Sheet sheet = workbook.getSheetAt(0);
//                Row row = sheet.createRow(Row);
//                Cell cell = row.createCell(0);
//                cell.setCellValue(Row);
//                cell = row.createCell(1);
//                cell.setCellValue(c.getFirstName());
//                cell = row.createCell(2);
//                cell.setCellValue(c.getMiddleName());
//                cell = row.createCell(3);
//                cell.setCellValue(c.getLastName());
//                cell = row.createCell(4);
//                cell.setCellValue(c.getAddress());
//                cell = row.createCell(5);
//                cell.setCellValue(c.getCompany());
//                cell = row.createCell(6);
//                String phone = c.getPhoneNumber().get();
//                cell.setCellValue(phone);
//                cell = row.createCell(7);
//                String email = c.getEmail().get();
//                cell.setCellValue(email);
//                cell = row.createCell(8);
//                String date = c.getSignificantDate().get();
//                cell.setCellValue(date);
//                cell = row.createCell(9);
//                cell.setCellValue(c.getWebsite());
//                cell = row.createCell(10);
//                cell.setCellValue(c.getRelationv());
//                cell = row.createCell(11);
//                String per = c.getRelatedPersonNo().get();
//                cell.setCellValue(per);
//                cell = row.createCell(12);
//                cell.setCellValue(c.getNotes());
//                cell = row.createCell(13);
//                cell.setCellValue(c.getsaveto());
//                Row++;
//                FileOutputStream fileWrite = new FileOutputStream(file);
//                workbook.write(fileWrite);
//                Contact.contacts.add(c);
//                fileWrite.close();
//                fileRead.close();
//                workbook.close();

    }

    public static void main(String[] args) throws ParseException{

        Scanner sc = new Scanner(System.in);

        boolean x = true;
        do{
            System.out.println("Enter 1 to create new contact");
            System.out.println("Enter 2 to view all contacts");
            System.out.println("Enter 3 to update existing contact");
            System.out.println("Enter 4 to delete contact");
            System.out.println("Enter 5 to search contact using name or number or email");
            System.out.println("Enter 6 to import contacts from file");
            System.out.println("Enter 7 to export contacts into a file");
            System.out.println("Enter 8 to exit");
            int a = sc.nextInt();
            Access access = new Access();;

            switch (a){
                case 1 :    System.out.println("Select the photo");
                            sc.nextLine();
                            String p = sc.nextLine();
                            System.out.println("Enter the first name");
                            String namef = sc.nextLine();
                            System.out.println("Enter the middle name");
                            String namem = sc.nextLine();
                            System.out.println("Enter the last name");
                            String namel = sc.nextLine();
                            System.out.println("Enter the address");
                            String address = sc.nextLine();
                            System.out.println("Enter the company name");
                            String company = sc.nextLine();
                            int yes = 0;
                            CustomHashMap<String,String> phoneNumber = new CustomHashMap<>();
                            do{
                                System.out.println("Enter the phone number");
                                String phoneNumber1 = sc.next();
                                if(!access.checkNumber(phoneNumber1)){
                                    System.out.println("Please enter a valid phone number\n");
                                    yes = 1;
                                }else{
                                    boolean ok = true;
                                    while(ok) {
                                        System.out.println("Enter 0 if no label \n Enter 1 if work number \n Enter 2 if home number \n Enter 3 if main number \n Enter 4 if custom");
                                        try {
                                            int pnt = sc.nextInt();
                                            if (pnt >= 5) {
                                                System.out.println("Please enter a proper choice \n");
                                            } else {
                                                phoneNumber.put(phoneNumber1, Enums.phoneNumber.getValue(pnt));
                                                System.out.println("Do you want to add more numbers?");
                                                System.out.println("Enter 1 for YES and 0 for NO");
                                                yes = sc.nextInt();
                                                ok = false;
                                            }
                                        }catch(InputMismatchException e){
                                            System.out.println("Enter an integer value only");
                                        }

                                    }
                                }
                            }while(yes != 0);
                            boolean ok1 = true;
                            int v = 0;
                            while(ok1) {
                                System.out.println("Select relation of  person by entering 0 if no label \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n Enter 4 if brother \n Enter 5 if spouse \n Enter 6 if child \n Enter 7 if friend \n Enter 8 if colleague \n Enter 9 if custom");
                                v = sc.nextInt();
                                if(v>=10){
                                    System.out.println("Please enter a proper choice");
                                }else{
                                    ok1 = false;
                                }
                            }
                                int yes2 = 0;
                                CustomHashMap<String,String> email = new CustomHashMap<>();
                                do{
                                    System.out.println("Enter the email");
                                    String email1 = sc.next();
                                    if (!access.checkMail(email1)) {
                                        System.out.println("Please enter a valid email\n");
                                        yes2 = 1;
                                    }else{
                                        boolean ok3 = true;
                                        while(ok3) {
                                            System.out.println("Enter 0 if no label \n Enter 1 if work email \n  Enter 2 if custom");
                                            int et = sc.nextInt();
                                            if(et >= 3){
                                                System.out.println("Please enter a proper choice");
                                            }
                                            else {
                                                email.put(email1, Enums.email.getValue(et));
                                                System.out.println("Do you want to add more emails?");
                                                System.out.println("Enter 1 for YES and 0 for NO");
                                                yes2 = sc.nextInt();
                                                ok3 = false;

                                            }
                                        }
                                    }

                                }while(yes2 != 0);
                                 int yes3 = 0;
                                 CustomHashMap<Date,String> date = new CustomHashMap<>();
                                do {
                                    System.out.println("Enter any significant date in format dd/mm/yyyy");
                                    String date1 = sc.next();
                                    if (!access.checkDate(date1)) {
                                        System.out.println("Please Enter the date in format dd/mm/yyyy");
                                        yes3 = 1;
                                    }else {
                                        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
                                        boolean ok4 = true;
                                        while(ok4) {
                                            System.out.println("Enter 0 if no label \n Enter 1 if birth date \n  Enter 2 if anniversary date \n Enter 3 if custom");
                                            int dt = sc.nextInt();
                                            if(dt >= 4){
                                                System.out.println("Please enter a proper choice");
                                            }else {
                                                date.put(date2, Enums.date.getValue(dt));
                                                System.out.println("Do you want to add more dates?");
                                                System.out.println("Enter 1 for YES and 0 for NO");
                                                yes3 = sc.nextInt();
                                                ok4 = false;
                                            }
                                        }
                                    }
                                }while(yes3 != 0);
                                    sc.nextLine();
                                    System.out.println("Enter any website/social media handles");
                                    String socialMedia = sc.nextLine();
                                    boolean ok5 = true;
                                    while(ok5) {
                                        System.out.println("Select related person by entering \n Enter 1 if father \n Enter 2 if mother \n Enter 3 if sister \n 4 if brother \n 5 if spouse \n 6 if child \n 7 if friend \n 8 if colleague \n 9 if custom");
                                        int person = sc.nextInt();
                                        if (person >= 10) {
                                            System.out.println("Please enter a proper choice");
                                        } else {
                                            System.out.println("Enter the phone number of the related person");
                                            String pnr = sc.next();

                                            if (!access.checkNumber(pnr)) {
                                                System.out.println("Please enter a valid phone number\n");
                                            } else {
                                                sc.nextLine();
                                                System.out.println("Enter any note if you want");
                                                String note = sc.nextLine();
                                                System.out.println("Enter 0 if save to phone \n Enter 1 if save to drive");
                                                int st = sc.nextInt();
                                                access.createContact(p, namef, namem, namel, address, company, phoneNumber, date, email, socialMedia, pnr, person, note, st, v);

                                            }
                                            ok5 = false;
                                        }
                                    }
                            break;
                case 2: access.getContacts();
                        break;
                case 3: System.out.println("Enter the phoneNumber of the contact to be updated");
                        String id = sc.next();
                        access.update(sc,id);
                        break;
                case 4: System.out.println("Enter the phoneNumber of the contact to be deleted");
                        String id1 = sc.next();
                        access.delete(sc, id1);
                        break;
                case 5: access.search();
                        break;
                case 6: try {
                        access.importFile();
                        }catch(IOException e){
                            System.out.println(e);
                        }
                        break;
                case 7: try{
                            access.exportFile();
                        } catch (IOException e) {
                                System.out.println(e);
                        }
                        break;
                case 8: x = false;
                        break;
                default: System.out.println("Please select a proper choice \n");
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
//            access.createContact("photo2", "Sarita", "Sunil", "Sha6rma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
//            access.createContact("photo2", "Kavita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);
//             access.createContact("photo2", "Lalita", "Sunil", "Sharma", "9876543210", 0,date2 , 0, "abc@gmail.com", 0, pnr, 1, st,3);


//            access.getContacts();

    }

}
