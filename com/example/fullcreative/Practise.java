package com.example.fullcreative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// to understand the object class
/*
Object class is the parent of all the classes.
If we dont know the type we can use Object class


 */
public class Practise {


    CustomArrayList<Integer> a = new CustomArrayList<>(Arrays.asList(1,2,3));

    public Practise() {
        super();
    }

    @Override
    public int hashCode() {

        // a integer value is provided for rach object
        // equal obj return same hashcode
        // but unequal obj may also have same hashcode
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        // basically compares the actual values of the obj
        // u can override according to ur needs
        // if overriding equals override hashcode also coz equal obj shld have equal hashcode
        return super.equals(obj);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
       //deep copy of array and shallow of 2d array
        return super.clone();
    }

    @NonNull
    @Override
    public String toString() {

       // getClass().getName() + '@' + Integer.toHexString(hashCode())

        //println calls this toString mathod before printing
        // System.out.println(c1) -> c1 is obj of class you can override it for this obj
        // System.out.println("Hello") -> even if u override it this will print the string
        // if c1 is the obj passed we can do...

        //return c1.hello();


        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args){
        Practise p = new Practise();
        System.out.println(p.a.toString());
        Practise.main();
    }

    public static void main(){

        System.out.println("Helo");
        String i = "hello";
        Integer j = new Integer(35);
       // System.out.println(i==j);
        System.out.println(i.equals(j));
        System.out.println(i.hashCode());
        System.out.println(j.hashCode());

    }
}
