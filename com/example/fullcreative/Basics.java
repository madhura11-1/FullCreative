package com.example.fullcreative;

// exception handling

public class Basics {


    /*

    Data Types

    data types are used to represent the variable types. String, int, boolean, etc

    Primitive types : basic types are primitives
                      Eg : int, boolean, char, short, long, byte, float, double

    Non Primitive Types : they can be said as more primitives together.
                          Like the String is more chars together. The array is more than one primitives together.


    Eg : int a
         String name;
         boolean if_tall


    User Defined Data Types : Class , Interface

     */



    /*

    Operators in java

    unary operators : ++(increment), -- (decrement), ~ (inversion) , ! (negation)
    Arithmetic operators : +,-,*,/
    Shift operators : << (left shift - multiply), >> (right shift - divide)
    Relational Operators : less than (<)
                           greater than (>)
                           less than equal to (<=)
                           greater than equal to (>=)
                           not equal to (!=)
                           equal to (==)
    Bitwise Operators : And (&)
                        Or (^)
    Logical Operators : And (&&)
                        Or (||)
    Ternary Operators : ? :
    Assignment Operators : =, +=, -=, *=, /=

    Conditions

    conditions are required to put some constraints to the working of the system.

    if...else statments are also used for applying conditions

    if (condition ) {
         executed when the condition is satisfied
    }
    else{
         executed if the if condition is not satisfied
    }

    There is else if condition also which is used if we want more conditions to be put.

    if(condition){
    }
    else if(condition){
    }
    else if(condition){
    }
    else{
    }


    Switch

    switch is another version of if else statements but with some modifications.
    In if else statements we can check logical expressions but here we can only check equal to operations
     */

    public void conditions() {

//        if (5 > 4) {
//            System.out.println("Yes");
//        } else if (5 > 6) {
//            System.out.println("Yes 2");
//        } else {
//            System.out.println("Yes 3");
//        }


        // break , continue (nested for loop)
//        int sit
//        switch(){
//
//            case ""
//
//        }


        String a = "2";  // char, byte,short, int, enum, String, Integer (float, double not possible)
        switch (a) {

            // here case first and second will have commonn output i.e. (case first or case second)
            case " ":
                System.out.println("empty");
            case "2":
                System.out.println("2");
            case "3":
                System.out.println("3");
//            case "6", "7" :                //possible in java 13
//                do smtg
//            case " ":
//                System.out.println("empty");

            default:
                System.out.println("default");
        }


/*        java 12 has this we can even return from swtich statement
           int  a = 1;
           char re     =
                switch(a){
                         case  0 -> '0';
                         case  1 -> '1';
                         case  2 -> '2';
                         default -> '?';
                };
 */
    }




    /*

    Loopings

    Looping helps in iterations. While dealing with large data iterating through it is required. Looping help in accessing each row in that
    data easily.
    There are various loops used in java as follows

    For loop
    in for loop we have to specify the starting condition or value of variable, the ending condition and the iteration condition.
    when we have fixed number of iterations we can use this loop.

    While loop
    while loop is executed when the condition given to it is met. The iteration condition is specified inside the body of the loop.
    mostly used when we have infinite iterations or iterations are not fixed.

    Do..While loop
    when we have to execute the loop atleast one we use do while loop.
    The execution part is specified in the do part and the condition in thw while part.

    for each loop
    iterate once thru the array


     */

    public void loop() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
        }

        int i = 50;
        while (i < 56) {
            System.out.println(i);
            i++;
        }

        do {
            System.out.println(i);
        }
        while (i <= 60);

        //for each loop
        String[] arr = {"ab", "bc", "ac", "xy"};

        for(String x : arr){
            System.out.println(x);
        }
    }


    /*

    Instanceof :

    checks weather obj is instance of the class/ superclass
    against null value always return zero (coz the reference obj is checked)

    class A  and class B is sublcass

    A a = new B();

    a instanceof A; (true)
    a instanceof B; (true)

    A a = null; // null is referenced here

    a instanceof A (false)
    a instanceof B (false)


    Enum

    data type which is a collection of constants

    */
        public enum Planets {
            mercury(1), venus(2), earth(3), mars(4), jupyter(5), saturn(6), uranus(7), neptune(8);

            private final int planet;
            private Planets(int n){
                this.planet = n;
            }

            public void getPlanet(){
                System.out.println(this.planet);
            }
        }


     /*
     Continue :

     this keyword is usued in loops to continue to the next iteration leaving the following code in the body of the loop

     Break:

     this keyword breaks the loop and comes out of it.
      */


    public static void main(String[] args) {

        Basics b = new Basics();
        b.conditions();

//        Planets p = Planets.mercury;
//        p.getPlanet();  //access
    }


    /*

    Memory allocation in java








     */





}


