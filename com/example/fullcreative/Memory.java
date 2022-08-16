package com.example.fullcreative;

import java.util.Vector;

public class Memory {

    /*

    program code

    static : static variables and mothods

    stack :  temporary memory specific to call and local variables and contain references to heap
             only the execution thread can access
             StackOverfLow exception
             faster


    heap :  all obj created stored here and entire application can accees it
            OutofMemoryError
            slower
            garbage collector everytime clear memeory here


            Memory Leaks : unused obj unnecessary in memory as they are still referenced  (outofmemory error)

            reasons : using excesssive static variables ( as they remain in program until it ends)
                      when connections are not closed
                      excessive heap use

     */

    public static void main(String[] args){

        Vector v = new Vector(222227);
        Vector v1 = new Vector(222222347);
        Vector v2 = new Vector(2222347);
        System.out.println(v.capacity());

    }


}
