package com.example.fullcreative;

public class OOPs {


/* Object Oriented Programming - Class and Object, Access Modifiers, This

    This is a concept that mainly deals with the objects and classes.

    Object : Object is any entity that you can specify. Like a car, student, bag, etc
             This object has its own properties and its own features.

    Class : Class is a structure which is used for representing this object. Like all the features and functions of the object can be
            specified and accesses using this class. The working of the object is controlled through the class methods.
            WE can create multiple objects for a single class.
            So the class has a structure to follow. Let us consider a Shop.
            A shop has a shopkeeper, its name, its address, number of items in it, etc.
            We can represent this shop using a class as follows.

    Access Modifiers

    Access modifiers are such keywords that help in accessing the variables and functions in the class.
    Depending upon the modifiers whether being public, private , protected the functions and variables can be accessed.

    Public : accessible from everywhere and to everyone
             The variables or functions with public access can being accessed outside the class easily. even outside the file from another file also.

    Private : accessible only inside the class. No external access possible

    Protected : It is accessible within the child classes and also if any internal class if declared.
                The package in which it is declared, we can access them from any class of same package.

     This keyword

     this keyword is basically used to refer to the present object you are dealing with.
     mostly used to separate the current object variables and the parameters passed if the names are same

 */

    public class Shop {

        private String name_of_Shop;
        protected String address;
        public String name_of_Shopkeeper;

        public String getName_of_Shop() {
            return name_of_Shop;
        }

        public void setName_of_Shop(String name_of_Shop) {
            this.name_of_Shop = name_of_Shop;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName_of_Shopkeeper() {
            return name_of_Shopkeeper;
        }

        public void setName_of_Shopkeeper(String name_of_Shopkeeper) {
            this.name_of_Shopkeeper = name_of_Shopkeeper;
        }
    }



/*
    Static keyword  // stored in heap

    Static is a keyword that is used to declare the variables only once. There can be static methods also.
    When you declare a variable to be static the memory is allocated to it only once. So all the objects that will get created will have that same
    static variable everytime.
    Usually we use this when we have a common entity for all objects of the class. Or during counting also.

    Eg :  Suppose we take game of Hockey. There are always 11 players fixed for a team. So if we create a class of a hockey team there
          will be a variable called number-of_players which will always remain fxed to 11.

     Static methods :
     WE can also declare methods in a class as Static. Static methods are useful when you dont have to create an object and still access the
     method inside the class. inside static method only static variables and static functions can be called.

     constant : static + final

     static : only one copy in memory for all objs and modifiable

     final : only one value and cannot modfiy the value but diff memory for each obj


 */

    public void exceptionFun0() throws NullPointerException{

        String ab = null;
        if(ab.equals("ab")){
            System.out.println("equality found");
        }else{
            System.out.println("not equal");
        }
    }

    public void exceptionFun() {

        String a = null;
        try {
            {
                if (a.contains("s")) {
                    System.out.println("not null");
                }
            }

        } catch (NullPointerException e) {

            System.out.println("null exception caught");
            System.out.println(e.toString());

        }

//        finally{
//                //excuted compulsory even if exception occured or not
//          }

        try {
            exceptionFun0();
        }catch (NullPointerException e){
            System.out.println(e.toString() + " 2");
        }

    }

    public static void main(String[] args){

        OOPs op = new OOPs();
        op.exceptionFun();

    }

}

     class HockeyTeam{

        String name;
        String coach_name;
        static int number_of_players = 11;
    }

    // System.out.print(HockeyTeam.number_of_players);


/*
 EXception Handling       (null pointer, io exception, arithmetic(divide by 0)                             // errros : errors cannot be recovered and not understood during compile time
                           ,illegal argument : get lenght of null string,or passing null)                    outofmemory : infinte loop/infinite recursion
   programs when have faults throw exceptions. Handling,  catching them is exception handling

   Checked : compile time exceptions (have to be try/caught) EXception class -- io exception, filenotfound, classnotfound
   Unchecked : runtime exception (use or not use try or catch or throw) RunTimeException class     ---- array index out of bound, null pointer, divide by zero, illegal argument
   (no one is better or less functionally)


   stack comes into picture

   either catch the exception or pass on to the call stack which might be catched there





 */

