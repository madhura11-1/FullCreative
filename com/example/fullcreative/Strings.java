package com.example.fullcreative;

public class Strings {

    /*
    String  : array of char

    implements CharSequence, Comparable and Serializable interface

    String are immutable (change or update string new instance is created)  // alternate : Stringbuilder , string buffer

    CharSequence : represnts sequence of characters

    String constant pool  : special memory to store string value in heap only
                           JVM checks if string present, if found reference to the same is returned or else create new

                 Eg : String a = new String("Abc")     a -> heap stored        Abc -> also in tne heap
                 all those created with new keyword - > stored in the heap
                 all those without new - > stored in the pool

                 intern() -> converts new keyword strings to pool strings
                 String as = "Ab";
                 String ab = new String("Ab).intern() -> stored in pool
                 as == ab ->true

                 String b ="xy"
                 String gb = new STring("xy")
                 b.equals(gb) -> true
                 b == gb -> false


    STringBuffer : same as builder only 2 diff

    1. Speed buffer is slower
    2. thread syncronization (buffer allowes only one thread acees -> much safer)
       builder allows multiple thread access

    StringBuilder :  mutable string
    methods : StringBuilder sb=new StringBuilder("Hello ");  // capacity 16 incre - > cap*2+2
              insert(inx1,string), delete(inx1,inx2), replace(inx1,inx2), lenght(), substring(ind1,inx2)

    method : concat(), equals(obj ->comapre values of obj), charAt(), indexOf(), valueOf(convert into String), replace(old,new)

    why immutable : security over the network / databse
                    multiple threads can access the reference
                    if many references to a string and one of them modifies it others will also get that modified value (so immutable)




                    String	  StringBuffer	StringBuilder
Mutable	              No	      Yes	        Yes
Thread-Safe        	 Yes	      Yes	         No
Time Efficient	      No	      No	         Yes
Memory Efficient	  No	      Yes	        Yes

     */


    public static void main(String[] args){

    }
}
