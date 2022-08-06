package com.example.fullcreative;

public class Pillars_of_OOPs {
  /*
   Four concepts that are called as pillar of OOPs :
   1. Inheritance
   2. Abstraction
   3. Encapsulation
   4. Polymorphism



   1. Inheritance (is a relationship)

   Inheritance is a parent child relationship. Taking a class as parent class (super class) and then the other class who is considered as a child
   inherits all the characteristics ( variables and functions) of this parent class.
   Mostly all the day to day functions we do can we represented using the inheritance.
   The extends keyword is used to extend the parent to the child.
   The subclass can override the methods in the super class;

   Types of Inheritance

   Single Level : one Child class and one parent class only

   Multi Level :  a class itself inherits from a parent class and then acts as a parent for the other child class.

   Hierarchical : from one parent class multiple child classes inherit the features

   Multiple Inheritance : Here the child class gets its features from more than one parent classes.
                          In java multiple inheritance is not supported hence we can use interfaces to deal with this issue.



   Eg : Game is one class and then there are many games like football, hockey, etc. So the basic features remain the same.
        Below are the examples of all the different inheritances using the example

   */

  // Single Level

  public class Game{                 // if no constructor; auto created by compiler

      public String type;
      protected String name;
      protected int no_of_players;

//      public Game(){
//
//      }

      public Game(String type, String name, int no_of_players){
          this.type = type;
          this.name = name;
          this.no_of_players = no_of_players;
      }

      public void start_Game(){
          System.out.println("Game started");
      }

      public void play(){
          System.out.println("Game is being played");
      }

      public void finish_Game(){
          System.out.println("Game finished");
      }
  }

  public class Football extends  Game{             // subclass constructor has first duty to call super class constructor  (no arg const will call supers no arg only)

      public int no_of_referees;
      public String rules;

      public Football(String type, String name, int no_of_players, int no_of_referees, String rules){

          super(type,name,no_of_players);
          this.no_of_referees = no_of_referees;
          this.rules = rules;

      }

      public void isRuleVoilated(){


          System.out.println("Checking if there is a violation in Football");

      }

      @Override                        // overridden method of parent class
      public void finish_Game(){
          super.finish_Game();
          System.out.println(this.type);
          System.out.println(this.name);
          System.out.println("Game of football is over");
      }

  }

   // Multi Level Inheritance

    public class Women_Football extends Football{

      public int field_size;

      public Women_Football(String type, String name, int no_of_players, int no_of_referees, String rules,int field_size){

          super(type,name,no_of_players,no_of_referees,rules);
          this.field_size = field_size;
      }

      public void getfield_size(){
          System.out.println("Field size for women football " + field_size);
      }

    }


//  // Hierarchical Inheritance
//
//    public class Hockey extends Game{
//
//      public String ball_weight;
//      public String Rule_hockey;
//
//      public void isRule1Violated(){
//
//          System.out.println("Checking if there is a violation in Hockey");
//
//      }

//    }

  // Multiple inheritance

    interface milk{
      public void white();
    }

    interface coffee{
      public void dark_brown();
    }

    abstract class cold_coffee{
      public void brown(){

      }
    }

    public class coffee_variety extends cold_coffee{

//      @Override
//      public void white(){
//          System.out.println("Milk");
//      }
//
//        @Override
//        public void dark_brown() {
//            System.out.println("Coffee");
//        }

        @Override
        public void brown() {
            System.out.println("Cold Coffee");
        }
    }

//    cold_coffee cof = new cold_coffee();


    /*

    Abstraction

    Abstraction is displaying only the required and essential details to the user and hiding the irrelevant ones from the user.
    It helps the user to access the objects more easily.
    interfaces and abstract methods or classes can be used to implement abstraction.


    Interface

    interface is like a class only just that the methods declared inside do not have any body i.e. they are abstract methods
    The class which implements this interface then has to  define that particular abstract method.
    it has no object;
    all methods and variables are implicitly public (coz : it needs to be implemented into other classes; if  private : nobody can implement it ; if protected : only subclasses and package classes can implement it)

    Abstract class :

    aim : act as base class
    class declared with abstract keyword is an abstract class or a class that has a abstract method is automatically declared abstract
    A abstract class can have both normal methods as well as abstract methods. Data Abstraction is easily achieved through this.
    All the abstract methods inside must be defined in the subclass or child class.

    Abstract method :

    Abstract methods are those methods which do not have any method body. These are also helpful in data abstraction.

    Overriding :

    overriding is a concept where the method has the same name and same parameters but is declared in parent and child class
    combination.

     */


    public interface cover{

        public String color = "Brown"; // public, static and final coz interface cannot be initiated as obj

        public void Dimensions();

//        public static void get_color(){   for static methods u have to give definition and cannot override this in implemeting class
//            System.out.println(color);     but u can declare same method there
//        }       // access cover.get_color()
    }

    public class Pillow implements cover{

        int length;
        int breadth;
        int width;
        String material;

        public void SetDimensions(int length, int breadth, int width){

            this.length = length;
            this.breadth = breadth;
            this.width = width;

        }

        public void setMaterial(String material){
            this.material = material;
        }

        public void Dimensions(){

            System.out.print("Length " + length + "\nBreadth " + breadth + "\nWidth " + width);

        }
//
//        public static void get_color(){
//            this u can do as it is not a overriden method
//        }

    }



    abstract  class Wooden_Plank{          //cannot create an instance
                                           // default public in nature
        private int length;
        int breadth;
        int width;

        public Wooden_Plank(int l, int b, int w){
            length = l;
            breadth = b;
            width = w;
        }

        abstract void use();

        public int getLenght(){
            return length;
        }

        public void area(){
            System.out.println(length*breadth);
        }
    }

    class Table extends Wooden_Plank {

        int no_of_items_kept;
        int no_of_chairs;

        public Table(int l,int b,int w){
            super(l,b,w);
        }

        @Override
        void use() {
            Wooden_Plank w = new Table(2,3,4);
            int length1 = w.getLenght();
            System.out.println("Used a table of area " + length1*breadth);
        }
    }


    public static void main(String[] args){


        Football f = new Pillars_of_OOPs().new Football("Field Game", "UK FC", 11, 3, "Hand Foul");
        f.start_Game();
        f.play();
        f.finish_Game();

        Game g = f;
        boolean tr = g instanceof Football;   // true (coz g is pointing to f )
        boolean fr = g instanceof Game;       // true (coz g pointing to f and f is subclass of Game)

        System.out.println(tr + " " + fr);

        Women_Football w = new Pillars_of_OOPs().new Women_Football("Women Field Football", "WUK FC", 11, 3,"Hand Foul",600);
        w.start_Game();
        w.play();
        w.isRuleVoilated();
        w.finish_Game();
        w.getfield_size();

        Football football = new Pillars_of_OOPs().new Women_Football("Women Field Football", "LiverPool WFC",11,3,"Hand FOul",600);
        football.isRuleVoilated();
        football.finish_Game();

        Game game = new Pillars_of_OOPs().new Women_Football("Women Field Football3", "Manchester WFC",11,3,"Hand FOul",600);
        game.finish_Game(); // Whyyyyyyyyyy


        Table t = new Pillars_of_OOPs().new Table(2,2,3);
        t.use();
        System.out.println(t.breadth);
        System.out.println(t.getLenght());
        t.area();

        Wooden_Plank wp = t;
        wp.area();

//        Pillow p = new Pillars_of_OOPs().new Pillow();
//        p.SetDimensions(4,5,6);
//        p.Dimensions();
//
//        cover c = new Pillars_of_OOPs().new Pillow();
//        c.Dimensions();
//        System.out.println(cover.color);


    }

    /*

    Encapsulation

    Encapsulation is encapsulating the entire data together. here also we do hiding of the data but this hiding is from the other
    classes present.
    Public, Private and Protected are the keywords that are used here to protect the data or give access whereever needed.

     */

    public class Shop {

        private String name_of_Shop;
        private String address;
        private String name_of_Shopkeeper;

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

    Polymorphism

    polymorphism is many forms. So different forms of the thing will always be a useful object.
    Like a clay can be moulded into various forms according to the requirements.
    In coding we can achieve polymorphism by using the same function name with different parameters. i.e. overloading

    Overloading

    It is a concept where a function has the same name but the parameters passed to it differe or the return type differs.

    The polymorphism where we use overloading is called compile time polymorphism

    Overriding

    Here the function name is same, the parameters passed are also same just that they are used in parent and child class combinnation

    The polymorphism where we use overriding is called run time polymorphism


     */

    class Makeup{

        String product1;
        String product2;
        String product3;

        public void makeup(int light){
            System.out.println("Light makeup");
        }

        public void makeup(int a, int b){
            System.out.println("Makeup not so dark nor light");
        }

        public void makeup(int dark, int a, int b){
            System.out.println("Dark and Heavy makeup");
        }

    }

    class Makeup_Hairstyle extends Makeup{

        String hairstyle1;
        String hairstyle2;

        public void makeup(int light){
            System.out.println("Makeup with Hairstyle");
        }

    }


}
