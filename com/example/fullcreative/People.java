package com.example.fullcreative;

 abstract class People {

    String photo;
    String firstName;
    String middleName;
    String lastName;

    public abstract String getPhoto();

    public abstract void setPhoto(String photo);

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getMiddleName();

    public abstract void setMiddleName(String middleName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);
}
